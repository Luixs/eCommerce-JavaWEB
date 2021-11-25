package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DAO {
	private String url = "jdbc:postgresql://localhost:5432/l2Store";
	
	private String user = "postgres";
	
	private String password = "postgres";
	
	
	public Connection conectar() {
		Connection con;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//------------------- TESTANDO A CONEXÃO
	public void TesteConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//------------------- INSERIR USUÁRIO
	public void inserirUsuario(JavaBeans user) {
		String create = "INSERT INTO users (name, lastName, birthday, gender, mail, pass) VALUES (?, ?, ?, ?, ?, ?)";
		String pass = user.getPass();
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			//MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes(), 0, pass.length() );
			String newPass = new BigInteger(1, md.digest()).toString(16);
			pst.setString(1, user.getName());
			pst.setString(2, user.getLastName());
			pst.setString(3, user.getBirthday());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getMail());
			pst.setString(6, newPass);
			pst.executeUpdate();
			con.close();
			System.out.println("Usuário Cadastrado no sistema");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//-------------------VERIFICANDO USUÁRIO
	public Boolean logarUsuario(JavaBeans user) {
		String pass = user.getPass();
		String array[] = new String[3];
		String readUser = "SELECT (name, mail, pass) FROM users WHERE mail=?";
		Boolean cod = false;
		try {
			//CRIPTOGRAFANDO SENHA
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pass.getBytes(), 0, pass.length() );
			String newPass = new BigInteger(1, md.digest()).toString(16);
			//-------------------
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(readUser);
			pst.setString(1, user.getMail());			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String resutado = rs.getString(1);
				array = resutado.split(",");
				user.setName(array[0].substring(1));
				//CONFERINDO A SENHA
				if((array[2].substring(0,32).equalsIgnoreCase(newPass))) {
					cod = true;
				}				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return cod;
	}
	//---------------ORDEM DE COMPRA
	public void criarOrdem(JavaBeans user) {
		String create = "INSERT INTO ordersBuy (id_products, value, name, mail) VALUES (?, ?, ?, ? )";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			//MD5
			pst.setString(1, user.getCompras());
			pst.setString(2, user.getValorCompras());
			pst.setString(3, user.getName());
			pst.setString(4, user.getMail());
			pst.executeUpdate();
			con.close();
			System.out.println("ORDEM CRIADA");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
