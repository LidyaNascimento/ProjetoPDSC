package chamados.mapeamento;

public class ChamadoMapeamento {
	
	private String titulo;
	private String descricao;
	private Long usuario_id;	
	private Long endereco_id;


	public ChamadoMapeamento() {
		
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
