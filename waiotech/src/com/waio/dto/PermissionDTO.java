package com.waio.dto;

import java.util.List;

public class PermissionDTO {

	private String permission;
	private List<String> subPermission;
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
	public List<String> getSubPermission() {
		return subPermission;
	}
	/**
	 * @param subPermission the subPermission to set
	 */
	public void setSubPermission(List<String> subPermission) {
		this.subPermission = subPermission;
	}
}
