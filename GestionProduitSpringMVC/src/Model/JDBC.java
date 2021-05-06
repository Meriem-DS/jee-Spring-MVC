package Model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/springmvc";
    static final String USER = "root";
	static final String PASS ="";
    public  Connection conn = null;
	public Statement stmt = null;
	ArrayList<Produits> produit = new ArrayList<Produits>();
	
   	//Se connecter à la BD$$$$$$$$$$$$$
	
  public Connection getConnection() throws SQLException {
	  try {
	      Class.forName(JDBC_DRIVER);
	      }catch(Exception e) {
	     	  System.out.println(e);}
	     conn =(Connection) DriverManager.getConnection(DB_URL,USER,PASS);
	return conn;
  }
  
    // PARTIE USER§§§§§§§§§§§§§§§§§§§§§§§§
  
//Avoir la liste des username/password adéquate avec les parametres insérée
 public  User GetUser(String login, String password) throws SQLException{
	 User u=null;
	 Connection connex=this.getConnection();
	 Statement stmt= (Statement) connex.createStatement();
     String sql = "SELECT * FROM login where UserName='"+login+"' and Password='"+password+"'";
     ResultSet rs = stmt.executeQuery(sql);
     while(rs.next()){
   	  u= new User(rs.getString("UserName"),rs.getString("Password"));
   	
     }
     connex.close();
return u;
	 
	  
  }


      //PARTIE PRODUCT §§§§§§§§§§§§§§
   

   //RETURN LISTE DES PRODUITS insérés dans La BD
    public ArrayList<Produits> FindAllProductS() throws SQLException {
	   Connection connex=this.getConnection();
	   Statement stmt= (Statement) connex.createStatement();
	   String sql = "SELECT * FROM product order by id desc";
	      ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			 produit.add (new Produits(rs.getInt("id"),rs.getString("nomProduit"), rs.getFloat("Prix"),rs.getString("Fournisseur")));
	       } 
		connex.close();
    return produit;
}
    
   //ADD PRODUCT TO DATA BASE
    public void AddProduct(String name,Float prix,String fournisseur) throws SQLException {
    	Connection connex=this.getConnection();
 	   Statement stmt= (Statement) connex.createStatement();
 	   String sql = "Insert into  product(nomProduit,Prix,Fournisseur) values ('"+name+"' ,'"+prix+"','"+fournisseur+"')";
 	   stmt.executeUpdate(sql);
 	   connex.close();
    }
    
    
   // UPDATE PRODUCT
    public void UpdateProduct(int id,String name,Float prix,String fournisseur)throws SQLException {
      Connection connex=this.getConnection();
      Statement stmt= (Statement) connex.createStatement();
      String sql = "Update product Set id='"+id+"',nomProduit='"+name+"',Prix='"+prix+"',Fournisseur= '"+fournisseur+"'    where id='"+id+"'";
      stmt.execute(sql);
      connex.close();
       }
    
    
   //DELETE PRODUCT
    public void DeleteProduct(int id) throws SQLException {
    	 Connection connex=this.getConnection();
    	 Statement stmt= (Statement) connex.createStatement();
    	//Supprimer produit qu'on a déja récupéré son ID( selectionnée par l'utilisateur )
		 String sql = "delete from product where id='"+id+"'"; 
		 stmt.executeUpdate(sql);
		 connex.close();
	}
   
}