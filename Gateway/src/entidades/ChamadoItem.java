
package entidades;

import java.util.Date;

import entidades.Chamado;

public class ChamadoItem {
	
	private String titulo;
	private String descricao;
	private Long valor;
	private Chamado chamado_id;
	private Long funcionario_id;
	private Date criado_em;
	private Date atualizado_em;
	
	public ChamadoItem() {
		
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
