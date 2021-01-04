package ecoleapp;

import java.sql.*;

public class Professeur {
    Connection con;
    Statement stm;
    ResultSet rst;
    public int CNI;
    public String nom_p,prenom_p;
    public int salaire;
    public int  log_p;
    public int passwrd_p;

//    constrecteur
    public Professeur(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/Professeur","","");
            stm=con.createStatement();
        }catch(Exception e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
    
//    gerer login est password

    public void gerer_log_psswrd(){
        try {
            float x= (float) (Math.random()*10000);
            float y= (float) (Math.random()*10000);
            log_p=(int)x; passwrd_p=(int)y;
            String query="INSERT INTO Professeur (log_p,passwrd_p) VALUES ("+log_p+","+passwrd_p+")";
            stm.executeUpdate(query);

        }catch (Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
//      ajouter prof
    
    public void ajoute_p(int CNI,String nom_p,String prenom_p,int salaire){
        try{
            String query="INSERT INTO Professeur VALUES ("+CNI+","+nom_p+","+prenom_p+","+salaire+")";
            stm.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println("Erreur !!"+e);

        }
    }
    
//    supprimer prof 
    
    public void supp_p(int CNI){
        try{
            String query="DELETE FROM Professeur where CNI="+CNI;
            stm.executeUpdate(query);

        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
    
//    affiche prof
    public void affiche_p(){
        try{
            String query="select * from Professeur ";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des professeurs:");
            while(rst.next()){
                int CNI=rst.getInt("" + "CNI");
                String nom_p=rst.getString("nom");
                String prenom_p=rst.getString("prénom");
                int salaire=rst.getInt("salaire");
                System.out.println(CNI+"\t"+nom_p+"\t"+prenom_p+"\t"+salaire);
            }
        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
    
    
//    ajouter un salaire

    public void ajoute_salaire(int CNI,int s){
        try{
            String query="UPDATE Professeur SET salaire=salaire+"+s+" WHERE CNI="+CNI+"";
            stm.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }

    
    public static void main(String[] args) {
        Professeur p=new Professeur();
        p.gerer_log_psswrd();
    }
}
