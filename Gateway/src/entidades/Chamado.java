package entidades;

public class Chamado {
	
	String titulo;
	
	String descricao;
	
	Long usuario_id;
	
	Long endereco_id;
	

	public Chamado() {
		
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


	public Long getEndereco_id() {
		return endereco_id;
	}


	public void setEndereco_id(Long endereco_id) {
		this.endereco_id = endereco_id;
	}
	
	
	

}
