package model;

public class JavaBeans {
	private String id;
	private String name;
	private String lastName;
	private String birthday;
	private String gender;
	private String mail;
	private String pass;
	private String compras;
	private String valorCompras;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String id, String name, String lastName, String birthday, String gender, String mail, String pass, String compras, String valorCompras) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.birthday = birthday;
		this.gender = gender;
		this.mail = mail;
		this.pass = pass;
		this.compras = compras;
		this.valorCompras = valorCompras;
	}
	
	public String getCompras() {
		return compras;
	}
	
	public void setCompras(String compras) {
		this.compras = compras;
	}
	
	public String getValorCompras() {
		return valorCompras;
	}
	
	public void setValorCompras(String valorCompras) {
		this.valorCompras = valorCompras;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
