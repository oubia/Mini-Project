
package mini_projet;
import java.sql.*;

public class Etudiant {
    Connection con;
    Statement stm;
    ResultSet rst;
    public String nom_e,prenom_e;
    public int CNE,abs;
    public int payment;
    public int note;
    public String nom_c;

    public Etudiant(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl ","hr","hr");
            stm=con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }

    public void ajoute_e(String  nom_e,String prenom_e,int CNE,String nom_c){
        try{
            String query="INSERT INTO Etudiant (nom_e, prenom_e,CNE,nom_c)VALUES ('"+nom_e+"','"+prenom_e+"',"+CNE+",'"+nom_c+"')";
            stm.executeUpdate(query);
        }
        catch (SQLException e){
            System.out.println("Erreur !!"+e);

        }
    }
    public void supp_e(int CNE){
        try{
            String query="DELETE FROM Etudiant where CNE="+CNE;
            stm.executeUpdate(query);

        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void affiche_e(){
        try{
            String query="select * from Etudiant ";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des etudiants:");
            while(rst.next()){
                int CNE=rst.getInt("CNE");
                String nom_e=rst.getString("nom_e");
                String prenom_e=rst.getString("prenom_e");
                String nom_c=rst.getString("nom_c");
                int payment=rst.getInt("payment");
                int note=rst.getInt("note");
                int abs=rst.getInt("abs");
                System.out.println(CNE+"\t"+nom_e+"\t"+prenom_e+"\t"+nom_c+"\t"+payment+"\t"+note+"\t"+abs);
            }
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void ajoute_payement(int CNE,int p){
        try{
            String query="UPDATE Etudiant SET payment="+p+" WHERE CNE="+CNE+"";
            stm.executeUpdate(query);
        }catch (SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
     public void ajoute_abs(int CNE,int ab){
        try{
            String query="UPDATE Etudiant SET ABS=(abs+"+ab+") WHERE CNE="+CNE+"";
            stm.executeUpdate(query);
        }catch (SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
      public void ajoute_note(int CNE,int note){
        try{
            String query="UPDATE Etudiant SET note="+note+" WHERE CNE="+CNE+"";
            stm.executeUpdate(query);
        }catch (SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Etudiant e1=new Etudiant();
//        e1.ajoute_note(122, 17);
        //e1.ajoute_e("jabri", "amin", 122, 2500, "1BAC_1");
//        e1.supp_e(122);
        e1.ajoute_abs(111, 1);
        e1.affiche_e();
        e1.stm.close();
        e1.con.close();
    }
}
