package pe.idat.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="rol")
public class RoleVo implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column
	private String type;


	@ManyToMany(mappedBy = "itemsRole", fetch=FetchType.EAGER)
	private Set<UserVo> itemsUser= new HashSet<>();

	public RoleVo() {
	}

	public RoleVo(Integer roleId, String type) {
		this.roleId = roleId;
		this.type = type;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<UserVo> getItemsUser() {
		return itemsUser;
	}

	public void setItemsUser(Set<UserVo> itemsUser) {
		this.itemsUser = itemsUser;
	}
}
