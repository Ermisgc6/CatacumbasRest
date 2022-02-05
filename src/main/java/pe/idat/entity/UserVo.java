package pe.idat.entity;

import java.io.Serializable;
import java.util.HashSet;
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
	private Integer userId;
	@Column(nullable = false, unique = true)
	private String username;;
	@Column(nullable = false)
	private String password;;
	
	@OneToOne
	@JoinColumn(name="trabajador_id", nullable=false, unique=true,  
	foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(trabajador_id) references trabajador(trabajador_id)"))
	private Trabajador trabajador;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "usuario_rol",
			joinColumns = @JoinColumn(name="user_id", nullable=false,
					foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(user_id) references usuario(user_id)")),
			inverseJoinColumns=@JoinColumn(name="role_id", nullable= false,
					foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(role_id) references rol(role_id)")))
	private Set<RoleVo> itemsRole= new HashSet<>();

	
	
	public UserVo() {
	}

	public UserVo(Integer userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
