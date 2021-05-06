package Model;

public class User {
	String login;
	String passWord;
	//constructeur
	public User(String login,String passWord) {
		super();
		this.login= login;
		this.passWord=passWord;
	}
	public String getL() {
		return login;
	}
	public String getP() {
		return passWord;
	}
	public void setL(String login) {
		this.login=login;
	}
	public void setP(String passWord) {
		this.passWord=passWord;
	}


}
