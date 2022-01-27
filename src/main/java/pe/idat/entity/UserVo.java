package pe.idat.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class UserVo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioId;
	@Column(nullable = false, unique = true)
	private String usuario;
	@Column(nullable = false)
	private String contraseña;
	
	@OneToOne
	@JoinColumn(name="trabajador_id", nullable=false, unique=true,  
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(trabajador_id) references trabajador(trabajador_id)"))
	private Trabajador trabajador;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="roles_users",
	joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<RoleVo> itemsRole;

	
	
	public UserVo() {
	}

	public UserVo(Integer usuarioId, String usuario, String contraseña) {
		this.usuarioId = usuarioId;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Set<RoleVo> getItemsRole() {
		return itemsRole;
	}

	public void setItemsRole(Set<RoleVo> itemsRole) {
		this.itemsRole = itemsRole;
	}
	
	
	
	
}
