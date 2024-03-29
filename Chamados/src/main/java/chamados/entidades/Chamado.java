package chamados.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "chamado", catalog = "chamados")
public class Chamado implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	 
	@Column(name = "descricao", nullable = false, length = 350)
	private String descricao;
	 
	@Column(name = "usuario_id", nullable = false)
	private Long usuario_id;
	
	@Column(name = "endereco_id", nullable = false)
	private Long endereco_id;
	 
		
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
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

	public Long getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}
	
	

}
