/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hanane Jagour
 */
public class aff_prof extends javax.swing.JInternalFrame {
    Connection con;
    Statement stm;
    ResultSet rst;
    int i=0;
    /**
     * Creates new form aff_prof
     */
    public aff_prof() {
        initComponents();
         try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            stm=con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
         affichage_prof();
    }

     public final void affichage_prof(){
        
         try{
            String query="select * from Professeur ";
            rst=stm.executeQuery(query);
            while(rst.next()){
                int CNI=rst.getInt("" + "CNI");
                String Nom=rst.getString("nom_p");
                String Prénom=rst.getString("prenom_p");
                int Salaire=rst.getInt("salaire");
              
                tab_prof.setValueAt(CNI, i, 0);
                tab_prof.setValueAt(Nom, i, 1);
                tab_prof.setValueAt(Prénom, i, 2);
                tab_prof.setValueAt(Salaire, i, 3);
               
               i=i+1;
           }
            
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
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
        tab_prof = new javax.swing.JTable();
        jLabelp = new javax.swing.JLabel();

        tab_prof.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CNI", "Nom", "Prénom", "Salaire"
            }
        ));
        jScrollPane1.setViewportView(tab_prof);

        jLabelp.setBackground(new java.awt.Color(153, 153, 255));
        jLabelp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelp.setText("La liste des professeurs");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabelp, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabelp, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_prof;
    // End of variables declaration//GEN-END:variables
}
