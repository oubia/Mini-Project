package com.company;
import java.sql.*;

public class Etudiant {
    Connection con;
    Statement stm;
    ResultSet rst;
    public String nom_e,prenom_e;
    public int CNE,abs;
    public int payment;
    public float[] note;
    public String nom_c;

    public Etudiant(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/Etudiant","","");//https://localhost:5503/em
            stm=con.createStatement();
        }catch(Exception e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }

    public void ajoute_e(int CNE,String nom_e,String prenom_e,String nom_c,int payment){
        try{
            String query="INSERT INTO Professeur VALUES ("+CNE+","+nom_e+","+prenom_e+","+nom_c+","+payment+")";
            stm.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println("Erreur !!"+e);

        }
    }
    public void supp_e(int CNE){
        try{
            String query="DELETE FROM Professeur where CNE="+CNE;
            stm.executeUpdate(query);

        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void affiche_e(){
        try{
            String query="select * from Etudiant ";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des etudiants:");
            while(rst.next()){
                int CNE=rst.getInt("" + "CNE");
                String nom_e=rst.getString("nom");
                String prenom_e=rst.getString("prénom");
                String nom_c=rst.getString("nom_classe");
                int payment=rst.getInt("payment");
                int note=rst.getInt("note");
                System.out.println(CNE+"\t"+nom_e+"\t"+prenom_e+"\t"+nom_c+"\t"+payment+"\t"+note);
            }
        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void ajoute_payement(int CNE,int p){
        try{
            String query="UPDATE Professeur SET payment=payment+"+p+" WHERE CNE="+CNE+"";
            stm.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
}
