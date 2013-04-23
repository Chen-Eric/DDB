package domain;

/**
 * RolePermissionId entity. @author MyEclipse Persistence Tools
 */

public class RolePermissionId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleId;
	private Integer permissionId;

	// Constructors

	/** default constructor */
	public RolePermissionId() {
	}

	/** full constructor */
	public RolePermissionId(Integer id, Integer roleId, Integer permissionId) {
		this.id = id;
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePermissionId))
			return false;
		RolePermissionId castOther = (RolePermissionId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getPermissionId() == castOther.getPermissionId()) || (this
						.getPermissionId() != null
						&& castOther.getPermissionId() != null && this
						.getPermissionId().equals(castOther.getPermissionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37
				* result
				+ (getPermissionId() == null ? 0 : this.getPermissionId()
						.hashCode());
		return result;
	}

}