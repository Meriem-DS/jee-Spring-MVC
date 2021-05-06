package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import Model.JDBC;
import Model.Produits;
import Model.User;

@Controller
public class HelloController {

	//JSP FILE FOR LOGIN PAGE  A AFFICHER 
@RequestMapping("/Login") //Login.do  
public String Login() {
	 return "index"; 
}

  //JSP FILE HOME PAGE 
@RequestMapping("/HOME") //HOME.do   
public String Home(@RequestParam(name = "login") String username,@RequestParam(name = "passWord") String passWord,Model model) throws SQLException {
	//Se connecter à la BD
	JDBC cnx=new JDBC();
	//MATCHING ENTRE CE QUI EST INSERRE ET CE QU'ON A AU NIVEAU DE LA BD
	User u=cnx.GetUser(username, passWord);
	if(u!=null) {
	//LIste des produits
    ArrayList<Produits> list= cnx.FindAllProductS();
    model.addAttribute("list", list);
	 return "produit";
	 }else {
    model.addAttribute("error", "Mot de passe ou login est incorrecte!!!!!");	 
		 return "index";}
}

 
//JSP FILE FOR ADDING PRODUCTS  A AFFICHER
@RequestMapping("/AddProduct") //CLASSE .JAVA ON VA LES AJOUTER DANS CONTREOLLER SOUS FORME REQUESTMapping(/.....)et doit return jsp
public String AjouterProduit(@RequestParam(name = "Product") String nomProduit,
		@RequestParam(name = "prix") Float prixProduit
		,@RequestParam(name = "fourn") String Fournisseur, Model model) throws SQLException {
	//Se connecter à la BD
	JDBC cnx=new JDBC();
	//nbre d'elt du liste avant l'insertion
	int size= cnx.FindAllProductS().size();
	//INSERTION DU NOUVEAU PRODUIT
	cnx.AddProduct(nomProduit, prixProduit, Fournisseur);
	//nbre d'elt du liste après l'insertion
	int newSize= cnx.FindAllProductS().size();
	//on compare s'il ya une difference donc le produit est bien ete inseree
	if(size!=newSize) {
		model.addAttribute("msg", "Produit a bien été ajouter à la base de données");
	//AFFICHER LA NOUVELLE LISTE
		JDBC ok=new JDBC();
		ArrayList<Produits> list= ok.FindAllProductS();
	    model.addAttribute("list", list);
	}else {model.addAttribute("msgError", "N'est pas bien inseree");}
return "produit";
}
//Update product et les afficher dans produit.jsp (After Submit)
@RequestMapping("/EditProduct" )
public String EditProduct(@RequestParam(name= "id") int id, @RequestParam(name = "Product") String nomProduit,
		@RequestParam(name = "prix") Float prixProduit
		,@RequestParam(name = "fourn") String Fournisseur, Model model) throws SQLException {
	//Se connecter à la BD
		JDBC cnx=new JDBC();
	//UPDATE
		cnx.UpdateProduct(id, nomProduit, prixProduit, Fournisseur);
		model.addAttribute("Editmsg", "produit a été bien modifié");
	//Afficher nouvelle liste
		JDBC ok=new JDBC();
		ArrayList<Produits> list= ok.FindAllProductS();
	    model.addAttribute("list", list);
	 return "produit";
	
		
}
//JSP FILE FOR DELETE PRODUCTS  A AFFICHER
@RequestMapping(value="/DeleteProduct/{id}" , method = RequestMethod.GET) 
public String DeleteProduct(@PathVariable ("id") int id, Model model) throws SQLException {
	//Se connecter à la BD
		JDBC cnx=new JDBC();
	//DELETE PRODUCT (id= id in parameter)
		cnx.DeleteProduct(id);
		model.addAttribute("Suppessionmsg", "produit a été bien suprimé");
	//afficher nouvelle liste des produits	
		JDBC ok=new JDBC();
		ArrayList<Produits> list= ok.FindAllProductS();
	    model.addAttribute("list", list);
	 return "produit";
	
}


//REDIRECT jsp produit to editProduct
@RequestMapping(value="/redirect/{id}/{nomProduit}",method = RequestMethod.GET)  //@GetMapping("/get/{id}")
public String redirect(@PathVariable("id") int id,@PathVariable("nomProduit") String nomProduit, Model model) 
{  
    model.addAttribute("id",id);
    model.addAttribute("nomProduit",nomProduit);
	return "EditProduct";  
}     



}


