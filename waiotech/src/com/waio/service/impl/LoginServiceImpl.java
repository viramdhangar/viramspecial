package com.waio.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waio.dao.ILoginDao;
import com.waio.domain.PermissionBean;
import com.waio.dto.AccessDTO;
import com.waio.dto.LoginDTO;
import com.waio.dto.MenuDTO;
import com.waio.dto.PermissionDTO;
import com.waio.dto.RolePermissionDTO;
import com.waio.service.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Autowired
	ILoginDao loginDao;

	@Override
	public boolean getAuthentication(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.getAuthentication(dto);
	}

	@Override
	public List<MenuDTO> getMenu(String id) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.getMenu(id);
	}

	@Override
	public List<RolePermissionDTO> getAccess(String id) {
		List<RolePermissionDTO> rolePermissionList = new ArrayList<RolePermissionDTO>();
		List<PermissionBean> permissionBeanList = loginDao.getAccess(id);
		String role = "";
		String previousPermission = "";
		RolePermissionDTO rolePermissionDTO = null;
		List<String> subPermission = null;
		for(PermissionBean pemissionBean : permissionBeanList){
			rolePermissionDTO = new RolePermissionDTO();
			
			if(!role.equalsIgnoreCase(pemissionBean.getRole())){
				role = pemissionBean.getRole();
				rolePermissionDTO.setProfileId(pemissionBean.getProfileId());
				rolePermissionDTO.setRole(pemissionBean.getRole());
				
				List<PermissionDTO> permissionList = new ArrayList<PermissionDTO>();
				PermissionDTO permissionDTO = new PermissionDTO();
				permissionDTO.setPermission(pemissionBean.getPermission());
				
				previousPermission = pemissionBean.getPermission();
				subPermission = new ArrayList<String>();
				if(StringUtils.isNotEmpty(pemissionBean.getSubPermission())){
					subPermission.add(pemissionBean.getSubPermission());
				}
				permissionDTO.setSubPermission(subPermission);
				permissionList.add(permissionDTO);
				rolePermissionDTO.setPermission(permissionList);
				rolePermissionList.add(rolePermissionDTO);
			}else{

				
				if(!previousPermission.equalsIgnoreCase(pemissionBean.getPermission())){
					PermissionDTO permissionDTO = new PermissionDTO();
					permissionDTO.setPermission(pemissionBean.getPermission());
				}else{
					if(StringUtils.isNotEmpty(pemissionBean.getSubPermission())){
						subPermission.add(pemissionBean.getSubPermission());
					}
				}

			}
			
		}
		return rolePermissionList;
	}
}
