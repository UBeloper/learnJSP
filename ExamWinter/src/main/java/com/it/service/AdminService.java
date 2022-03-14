package com.it.service;

import com.it.domain.AdminVO;

public interface AdminService {

	public AdminVO read(AdminVO admin);
	
	public boolean auth(AdminVO admin);
	// boolean으로
	
}
