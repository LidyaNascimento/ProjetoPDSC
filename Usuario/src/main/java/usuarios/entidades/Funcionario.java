package usuarios.entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "funcionario", catalog = "usuarios")
@Access(AccessType.FIELD)
@DiscriminatorValue("F")
@PrimaryKeyJoinColumn(name="usuario_id", referencedColumnName="id")
public class Funcionario extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "RG", nullable = false, length = 8)
	private String RG;


	public String getRG() {
		return RG;
	}


	public void setRG(String rG) {
		RG = rG;
	}
	
	//Adicionar atributo que informa se o funcionario está alocado em algum serviço
	
	
	
	

}
