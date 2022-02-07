package br.proj.rd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public UserDAO() {

	}
	
	public void inserir(User user) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into users (nome, email, pais) values (?, ?, ?)");
			p.setString(1, user.getNome());
			p.setString(2, user.getEmail());
			p.setString(3, user.getPais());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> consultar(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		List<User> usuarios = new ArrayList<User>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from users");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				int id = r.getInt("id");
				String nome = r.getString("nome");
				String email = r.getString("email");
				String pais = r.getString("pais");
				User user = new User(nome, email, pais);
				user.setId(id);
				usuarios.add(user);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void deletar(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from users where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(int id, String nome, String email, String pais ) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update users set nome = ?, email = ?, pais = ? where id = ?");
			p.setString(1, nome);
			p.setString(2, email);
			p.setString(3, pais);
			p.setInt(4, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public User consultarUser(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		User user = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from users where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();	
			
			while (r.next()) {
				int id2 = r.getInt("id");
				String nome = r.getString("nome");
				String email = r.getString("email");
				String pais = r.getString("pais");
				user = new User(nome, email, pais);
				user.setId(id2);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}