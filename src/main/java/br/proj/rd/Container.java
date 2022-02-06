package br.proj.rd;

import java.util.ArrayList;

//SIMULANDO UM BD
public class Container {

	private ArrayList<User> userList;
	private Integer idSequence;
	
	public Container() {
		super();
		userList = new ArrayList<User>();
		this.idSequence = 1;
	}	
	
	public void insert(User user) {
		user.setId(idSequence);
		this.userList.add(user);
		this.idSequence++;
	}	
	
	public ArrayList<User> selectAll(){
		return this.userList;
	}
	
	public void delete(int contador) {
		//this.userList.remove(chuchu); //Não podemos usar o indice NESTE CASO para remoção dos dados
		for (User u : this.userList) {
			if (u.getId() == contador) {
				this.userList.remove(u);
				break;
			}
		}
	}
	
	public void update(User user) {
		for (User u : this.userList) {
			if (u.getId() == user.getId()) {
				u.setEmail(user.getEmail());
				u.setNome(user.getNome());
				u.setPais(user.getPais());
				break;
			}
		}
	}
	
	public User selectById(Integer id){
		for (User u : this.userList) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
}

