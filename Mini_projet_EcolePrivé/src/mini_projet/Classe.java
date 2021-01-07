
package mini_projet;
import java.sql.*;
public class Classe {
   Connection con;
    Statement stm;
    ResultSet rst;
    
    public String nom_c;
  
    public Classe(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
            stm=con.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Erreur de chargement de pilote:"+e);
        }
    }
      public void affiche_c(){
        try{
            String query="select * from Classe ";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des classes:");
            while(rst.next()){
               
                String nom_c=rst.getString("nom_c");
              
                System.out.println(nom_c);
            }
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
       public void aff_etud_c(String nom_c){
        try{
            String query="select nom_e,prenom_e from etudiant where upper(nom_c)=upper('"+nom_c+"');";
            rst=stm.executeQuery(query);
            System.out.println("Voici la liste  des classes:");
            while(rst.next()){
               
                String nom_e=rst.getString("nom_e");
                String prenom_e=rst.getString("prenom_e");
                System.out.println(nom_e+" "+prenom_e);
            }
        }catch(SQLException e){
            System.out.println("Erreur !!:"+e);
        }
    }
    public void ajoute_c(String nom_c){
        try{
            String query="INSERT INTO Classe VALUES ('"+nom_c+"')";
            stm.executeUpdate(query);
        }
        catch (SQLException e){
            System.out.println("Erreur !!"+e);

        }
    }
    
     public static void main(String[] args) throws SQLException{
            Classe c1=new Classe();
            //c1.ajoute_c("2BAC_3");
            c1.aff_etud_c("1BAC_1");
           // c1.affiche_c();
         
     }
}
