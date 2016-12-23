package com.waio.dto;

import java.util.List;

public class RolePermissionDTO {

	private String profileId;
	private String role;
	private List<PermissionDTO> permission;
	
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
	public List<PermissionDTO> getPermission() {
		return permission;
	}
	/**
	 * @param permission the permission to set
	 */
	public void setPermission(List<PermissionDTO> permission) {
		this.permission = permission;
	}
}
