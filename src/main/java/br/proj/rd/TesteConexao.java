package br.proj.rd;
import java.lang.ref.WeakReference;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Teste de conexão
		Conexao c = new Conexao();
		c.getConnection();
		WeakReference<Object> ref = new WeakReference<Object>(c);
		c = null;
		//System.gc(); //Garbage Collector
		while(ref.get() != null) {
	       System.gc();
	       System.out.println(".");
	     }
		c = new Conexao();
		c.getConnection();
		
		
		//Teste de conexão Singleton
//		Tomate c;
//		c = Tomate.getInstance();
//		c.getConnection();
//		c.finalize();
//		c = Tomate.getInstance();
//		c.getConnection();
		
		
//		UserDAO dao = new UserDAO();
//		//User user = new User("Carlos", null);
//		//dao.addUser(user);
//		ArrayList<User> lista1 = dao.getListUser();
//		System.out.println(lista1);
//		
//		dao.removeUser(1);
//		System.out.println(lista1);
//		
//		lista1 = dao.getListUser();
//		System.out.println(lista1);
//		User user = new User("Raphael", "email@web.com");
//		user.setId(7);
//		dao.updateUser(user);
//		
//		System.out.println(lista1);
		
	}

}
