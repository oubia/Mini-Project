
package mini_projet;

import java.sql.*;
public class Professeur {
    Connection con;
    Statement stm;
    ResultSet rst;
    public int CNI;
    public String nom_p,prenom_p;
    public int salaire;
    private int  log_p;
    private int passwrd_p;

    public Professeur(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            stm=con.createStatement();
        }catch(Exception e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }



    public void ajoute_p(int CNI,String nom_p,String prenom_p){
        try{
            float x= (float) (Math.random()*10000);
            float y= (float) (Math.random()*10000);
            int log_pr=(int)x; int passwrd_pr=(int)y;
            String query1="INSERT INTO Professeur ( CNI,nom_p,prenom_p,log_p,passwrd_p) VALUES ("+CNI+",'"+nom_p+"','"+prenom_p+"',"+log_pr+","+passwrd_pr+")";
            stm.executeUpdate(query1);
        }
        catch (SQLException e){
            System.out.println("Erreur !!"+e);

        }
    }
    public void supp_p(int CNI){
        try{
            String query="DELETE FROM Professeur where CNI="+CNI;
            stm.executeUpdate(query);

        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void affiche_p(){
        try{
            String query="select * from Professeur ";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des professeurs:");
            while(rst.next()){
                int CNI=rst.getInt("" + "CNI");
                String nom_p=rst.getString("nom_p");
                String prenom_p=rst.getString("prenom_p");
                int salaire=rst.getInt("salaire");
                System.out.println(CNI+"\t"+nom_p+"\t"+prenom_p+"\t"+salaire);
            }
        }catch(Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }

    public void ajoute_salaire(int CNI,int s){
        try{
            String query="UPDATE Professeur SET salaire="+s+" WHERE CNI="+CNI+"";
            stm.executeUpdate(query);
        }catch (Exception e){
            System.out.println("Erreur !!:"+e);
        }
    }

    
    public static void main(String[] args) {
        Professeur p1=new Professeur();

//        p1.ajoute_p(141, "jadari", "khalid");
        //p1.supp_p(123);
        p1.affiche_p();
        
    }
}
