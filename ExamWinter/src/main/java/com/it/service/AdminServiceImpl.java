package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.AdminVO;

import lombok.Setter;

@Service
public class AdminServiceImpl implements AdminService {

	@Setter(onMethod_ = @Autowired)
	private AdminService service;
	
	@Override
	public AdminVO read(AdminVO admin) {
		return service.read(admin);
	}
	
	
}
