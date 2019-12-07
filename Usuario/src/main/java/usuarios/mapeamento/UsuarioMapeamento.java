package usuarios.mapeamento;


public class UsuarioMapeamento {
	
	private Long id;

	private String login;
	
	private String senha;
	
	private String nome;

	private String CPF;

	private String email;

	private String data_nascimento;
	
	private String criado_em;
	
	private String atualizado_em;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(String criado_em) {
		this.criado_em = criado_em;
	}

	public String getAtualizado_em() {
		return atualizado_em;
	}

	public void setAtualizado_em(String atualizado_em) {
		this.atualizado_em = atualizado_em;
	}
}
