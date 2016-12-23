package com.waio.domain;

public class PermissionBean {

	private String profileId;
	private String role;
	private String permission;
	private String subPermission;
	/**
	 * @return the profileId
	 */
	public String getProfileId() {
		return profileId;
	}
	/**
	 * @param profileId the profileId to set
	 */
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the permission
	 */
	public String getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	/**
	 * @return the subPermission
	 */
	public String getSubPermission() {
		return subPermission;
	}
	/**
	 * @param subPermission the subPermission to set
	 */
	public void setSubPermission(String subPermission) {
		this.subPermission = subPermission;
	}
}
