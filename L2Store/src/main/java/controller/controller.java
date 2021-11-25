package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class controller
 */
@WebServlet(urlPatterns = {"/controller","/Teste","/insert","/Login","/ordemCompra"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAO dao = new DAO();
	JavaBeans user = new JavaBeans();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		if(action.equals("/Teste")){
			teste(request, response);
		}
		else if(action.equals("/insert")) {
			novoUsuario(request, response);
		}
		else if(action.equals("/Login")){
			entrarUsuario(request, response);	
		}
		else if(action.equals("/ordemCompra")){
			System.out.println("ORDEM DE COMPRA REALIZADA");
			ordemCompra(request,response);
		}
		else {
			System.out.println("Não caiu aqui");
		}
	}
	
	
	protected void teste(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.TesteConexao();		
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
	protected void entrarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user.setMail(request.getParameter("user"));
		user.setPass(request.getParameter("password"));
		Boolean login = dao.logarUsuario(user);
		//SE CONSEGUIR ENTRAR
		if(login) {
			request.setAttribute("name", user.getName());
			RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
		
	}
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// SETANDO AS VARIÁVEIS DO JavaBeans
		user.setName(request.getParameter("name"));
		user.setLastName(request.getParameter("lastName"));
		user.setBirthday(request.getParameter("birthday"));
		user.setGender(request.getParameter("gender"));
		user.setMail(request.getParameter("mail"));
		user.setPass(request.getParameter("pass"));
		dao.inserirUsuario(user);
		//LEVANDO O NOME DO USUÁRIO
		request.setAttribute("name", request.getParameter("name"));
		RequestDispatcher rd = request.getRequestDispatcher("buy.jsp");
		rd.forward(request, response);
	}
	protected void ordemCompra(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String compras = request.getParameter("user");
		String value = request.getParameter("user2");
		user.setCompras(compras);
		user.setValorCompras(value);
		dao.criarOrdem(user);
		//LEVANDO O NOME DO USUÁRIO
		request.setAttribute("name", user.getName());
		RequestDispatcher rd = request.getRequestDispatcher("end.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
