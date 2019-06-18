package model;

public class UserCursoJava {
	
	private long id;
	private String nome;
	private String email;
	
	public UserCursoJava() {}
	
	public UserCursoJava(long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserCursoJava [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
}
