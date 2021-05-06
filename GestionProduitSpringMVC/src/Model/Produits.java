package Model;

public class Produits {
	private int id;
	private String nomProduit;
	private float Prix;
	private String Fournisseur;

	//CONSTRUCTEURS
	public Produits() {
		super();
	}

	public Produits(int id,String nomProduit, float Prix, String Fournisseur) {
		super();
		this.id=id;
		this.nomProduit = nomProduit;
		this.Prix = Prix;
		this.Fournisseur = Fournisseur;
	}

//GETTERS & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnomProduit() {
		return nomProduit;
	}

	public void setnomProduit (String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public float getPrix() {
		return Prix;
	}

	public void setPrix(float Prix) {
		this.Prix = Prix;
	}

	public String getFournisseur() {
		return Fournisseur;
	}

	public void setFourniseur(String Fournisseur) {
		this.Fournisseur = Fournisseur;
	}
	

}
