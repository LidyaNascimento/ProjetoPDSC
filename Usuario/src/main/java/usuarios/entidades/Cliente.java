package usuarios.entidades;

import java.io.Serializable;

import javax.persistence.*;;

@Entity
@Table(name = "cliente", catalog = "usuarios")
@Access(AccessType.FIELD)
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name="usuario_id", referencedColumnName="id")
public class Cliente extends Usuario implements Serializable{


	private static final long serialVersionUID = 1L;


	

}
