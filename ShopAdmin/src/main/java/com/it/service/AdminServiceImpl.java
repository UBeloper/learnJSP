package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.AdminVO;
import com.it.mapper.AdminMapper;

import lombok.Setter;

@Service
public class AdminServiceImpl implements AdminService {

	@Setter(onMethod_ = @Autowired)
	private AdminMapper mapper;
	
	@Override
	public boolean auth(AdminVO admin) {
		admin = mapper.read(admin);
		
		if(admin != null) {
			return true;	
		} else {
			return false;
		}			
	}

	
}
