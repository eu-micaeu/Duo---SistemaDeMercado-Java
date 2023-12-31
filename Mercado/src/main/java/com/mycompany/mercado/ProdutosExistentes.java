/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mercado;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author micae
 */
public class ProdutosExistentes extends javax.swing.JFrame {

    /**
     * Creates new form ProdutosExistentes
     */
    private static ProdutosExistentes menuProdutosExistentes;

    public ProdutosExistentes() {
        initComponents();
        mostrarProdutos();
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
    }

    public static ProdutosExistentes getProdutosExistentes() {
        if (menuProdutosExistentes == null) {
            menuProdutosExistentes = new ProdutosExistentes();
        }
        return menuProdutosExistentes;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID-PRODUTO", "NOME", "VALOR", "ESTOQUE"
            }
        ));
        jScrollPane1.setViewportView(tabProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public void mostrarProdutos(){
        DefaultTableModel tabModel = (DefaultTableModel) tabProduto.getModel();
        tabModel.setRowCount(0);
        try (Connection conexao = new Conexao().getConnection()) {
            String query = "SELECT id_produto, nome, valor, estoque FROM produto;";
            Statement statement = conexao.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id_produto");
                String nome = resultSet.getString("nome");
                float valor = resultSet.getFloat("valor");
                int quantidade = resultSet.getInt("estoque");
                tabModel.addRow(new Object[]{id, nome, valor, quantidade});
            }
        } catch (SQLException e) {
            System.out.println("ERRO NO SQL! - mostrarProdutos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabProduto;
    // End of variables declaration//GEN-END:variables
}
