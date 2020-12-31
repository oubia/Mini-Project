package com.company;
import java.sql.*;
public class Classe {
    Connection con;
    Statement stm;
    ResultSet rst;
    public String nom_c;
    public void ajoute_c(String nom_c){
        this.nom_c=nom_c;
    }
    public Classe(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/Classe","","");
            stm=con.createStatement();
        }catch(Exception e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
    public void ajoute_p(String nom_c){
        try{
            String query="INSERT INTO Classe VALUES ("+nom_c+")";
            stm.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println("Erreur !!"+e);

        }
    }
    public void supp_p(String nom_c){
        try{
            String query="DELETE FROM Classe where nom_c="+nom_c;
            stm.executeUpdate(query);

        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
}
