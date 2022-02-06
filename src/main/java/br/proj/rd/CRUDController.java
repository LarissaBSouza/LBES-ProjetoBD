package br.proj.rd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CRUDController
 */
@WebServlet("/CRUDController")
public class CRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Container cont;
	@SuppressWarnings("unused")
	private Integer teste = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDController() {
    	super();
        // TODO Auto-generated constructor stub
        this.cont = new Container();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
//		insertUser(request, response);
//		insertUser(request, response);
//		selectAllUsers(request, response);
//		updateUser(request, response);
//		selectAllUsers(request, response);
//		deleteUser(request, response);
//		selectAllUsers(request, response);
		
		
//		if (teste == 0) {
//			insertUser(request, response);
//			teste++;
//		}else {
//			selectAllUsers(request, response);
//			teste--;
//		}
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
		}
		switch(option) {
			case ("insertForm"):
				showInsertUser(request, response);
			break;
			case ("updateForm"):
				showUpdateUser(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				insertUser(request, response);
			break;
			default:
				selectAllUsers(request, response);
		}
	}
	
	private void showInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		User u = this.cont.selectById(id);
		request.setAttribute("user", u);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insertUser(HttpServletRequest tomate, HttpServletResponse alface) throws ServletException, IOException{
		//String nomeBack = tomate.getParameter("nome"); // ERRO
		String nomeBack = tomate.getParameter("name");
		String emailBack = tomate.getParameter("email");
		String paisBack = tomate.getParameter("pais");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null)) {
			if (!nomeBack.equals("")){
				User user1 = new User(nomeBack, paisBack, emailBack);
				this.cont.insert(user1);
			}
		}
		alface.sendRedirect("CRUDController");
	}
	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println(this.cont.selectAll());
		request.setAttribute("listUser", this.cont.selectAll());
		request.getRequestDispatcher("listTable.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.cont.delete(id);
		}
		response.sendRedirect("CRUDController");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User user1 = new User("Raphael", "Brasil", "raphael@rd.com.br");
//		user1.setNome("João");
//		user1.setId(2);
//		this.cont.update(user1);
		//String nomeBack = request.getParameter("nome"); // ERRO
		String nomeBack = request.getParameter("name");
		String emailBack = request.getParameter("email");
		String paisBack = request.getParameter("pais");
		String idBack = request.getParameter("id");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null) && (idBack != null)) {
			if (!nomeBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				User user1 = new User(nomeBack, paisBack, emailBack);
				user1.setId(id);
				this.cont.update(user1);
			}
		}
		response.sendRedirect("CRUDController");
	}
	
}
