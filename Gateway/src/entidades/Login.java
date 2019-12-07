package entidades;

public class Login {
	
	private Long id;
	private String login;
	private String senha;
	private String token;
	private String discriminator;
	
	public Login() {
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	


	public String getDiscriminator() {
		return discriminator;
	}



	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	

}
