package br.proj.rd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeiroBD
 */
@WebServlet("/PrimeiroBD")
public class PrimeiroBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private static UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimeiroBD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		String alterar =request.getParameter("alterar");
		if(id != null) {
			
			if(alterar.equals("0")) {
				userDAO.deletar(Integer.parseInt(id));
			}else if(alterar.equals("1")) {
				User user = userDAO.consultarUser(Integer.parseInt(id));
				request.setAttribute("id", user.getId());
				request.setAttribute("nome", user.getNome());
				request.setAttribute("email", user.getEmail());
				request.setAttribute("pais", user.getPais());
				
				request.getRequestDispatcher("formulario.jsp").forward(request, response);
			}
		}
		request.setAttribute("usuarios", userDAO.consultar());
		request.getRequestDispatcher("/").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getParameter("nome") != null && request.getParameter("email") != null && request.getParameter("pais") != null) {
			String var1 = request.getParameter("nome");
			String var2 = request.getParameter("email");
			String var3 = request.getParameter("pais");
			
			String id = request.getParameter("id");
			
			if(id != null && !id.isEmpty()) {
				userDAO.alterar(Integer.parseInt(id), var1, var2, var3);
			}else {
				User user = new User(var1, var2, var3);
				userDAO.inserir(user);
			}
			
			
			
			request.setAttribute("usuarios", userDAO.consultar());
			
		}
		
		request.getRequestDispatcher("/").forward(request, response);
	}
	
}