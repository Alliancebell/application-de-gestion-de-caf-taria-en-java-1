
package application_resto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Application_resto {

   
    public static void main(String[] args) {
       String url="jdbc:postgresql://localhost:5432/TPINF351";
       String user="postgres";
       String password="pyth@n";
       try{
           //etablir une connection a la base de données
           Connection connection=DriverManager.getConnection(url,user,password);
           //executer une requette sql
           String sql="SELECT * FROM auteur";
           Statement statement=connection.createStatement();
           ResultSet resultSet=statement.executeQuery(sql);
           //parcourir les resultats de la requete
           while(resultSet.next()){
               int id=resultSet.getInt("idauteur");
               String nom_encode=resultSet.getString("nom_encode");
               System.out.println("ID: "+id+",Name:"+ nom_encode);
           }
           //fermer les ressources
           resultSet.close();
           statement.close();
           connection.close();
       }catch(SQLException ex){
           ex.printStackTrace();//permet d'afficher les exceptions au niveau de la console
       }
    }
    
}
