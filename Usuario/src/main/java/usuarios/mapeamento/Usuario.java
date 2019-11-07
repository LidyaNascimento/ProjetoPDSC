package usuarios.mapeamento;

import java.util.Date;


public class Usuario {

	private String login;
	
	private String senha;
	
	private String nome;

	private String CPF;

	private String email;

	private Date data_nascimento;
	
	private Date criado_em;
	
	private Date atualizado_em;


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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Date getCriado_em() {
		return criado_em;
	}

	public void setCriado_em(Date criado_em) {
		this.criado_em = criado_em;
	}

	public Date getAtualizado_em() {
		return atualizado_em;
	}

	public void setAtualizado_em(Date atualizado_em) {
		this.atualizado_em = atualizado_em;
	}
}
