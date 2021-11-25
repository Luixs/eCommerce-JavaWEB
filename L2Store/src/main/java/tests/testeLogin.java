package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import model.DAO;
import net.bytebuddy.build.Plugin.Engine.Source.Empty;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;

public class testeLogin {
	DAO dao = new DAO();
	@Test
	public void testFazerLoginPagina() {
		// ---------------- TESTE COM WEBDRIVER
		System.setProperty("webdrive.chrome.driver", "C:\\Windows\\chromedriver.exe");
		//ABRINDO O NAVEGADOR E LOGANDO NO SITE
		WebDriver navegador = new ChromeDriver();
		navegador.get("http://localhost:8080/L2Store/index.html");
		navegador.findElement(By.linkText("LOGIN")).click();
		navegador.findElement(By.name("user")).sendKeys("teste@gmail.com");
		navegador.findElement(By.name("password")).sendKeys("123456");
		navegador.findElement(By.xpath("//button[text()='Entrar']")).click();
		
		//VERIFICANDO Elemento que existe apenas na pagina logada para ver se logou
		Dimension logou = navegador.findElement(By.id("carrinhoDeCompras")).getSize();
		assertEquals(logou != null, true);
		System.out.println("@Test -> Credenciais Corretas, logou");	
	}
	@Before
	public void testOpenConnection() throws Exception {
		System.out.println("--- Iniciando @Teste Conexão ---");
		//ESPERANDO QUE A CONEXÃO SEJA DIFERENTE DE NULO (SE A CONEXÃO FOR DIFERENTE DE NULL == TRUE) 
		assertEquals(dao.conectar() != null, true);
		System.out.println(dao.conectar());
		System.out.println("--- Conexão Realizada com Sucesso ---");
		
	}
	

}
