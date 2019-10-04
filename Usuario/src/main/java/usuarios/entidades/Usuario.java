package usuarios.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@Table(name = "usuario", catalog = "usuarios")
@Access(AccessType.FIELD) 
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
	    name="discriminator",
	    discriminatorType=DiscriminatorType.STRING, length = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "login", nullable = false, length = 50)
	private String login;
	
	
	@JsonbTransient //Essa annotation impede que o attributo seja inserido na resposta
	@Column(name = "senha", nullable = false)
	private String senha;
	
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	
	@Column(name = "CPF", nullable = false, length = 11)
	private String CPF;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	/*@Column(name = "discriminator", nullable = false, length = 1)
	private String discriminator;*/
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_nascimento")
	private Date data_nascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "criado_em")
	private Date criado_em;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "atualizado_em")
	private Date atualizado_em;



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
	
	

//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
	
}