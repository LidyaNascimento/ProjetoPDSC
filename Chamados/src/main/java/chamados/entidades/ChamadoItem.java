package chamados.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "chamado_item", catalog = "chamados")
public class ChamadoItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "descricao", nullable = false, length = 350)
	private String descricao;
	
	@Column(name = "valor", nullable = false)
	private Long valor;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chamado_id",
            referencedColumnName = "id")
	private Chamado chamado_id;
	
	//private Status status_chamado;
	
	@Column(name = "funcionario_id")
	private Long funcionario_id;
	
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

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Chamado getChamado_id() {
		return chamado_id;
	}

	public void setChamado_id(Chamado chamado_id) {
		this.chamado_id = chamado_id;
	}

	public Long getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(Long funcionario_id) {
		this.funcionario_id = funcionario_id;
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

