package com.it.domain;

import lombok.Data;

@Data
public class CartmemberDTO {
	
	private int cm_code;
	private String m_id;
	private String m_name;
	private int cm_total; // 영수증 하나에 만들어지는 정보이므로 cm에 가깝다고 생각해서 cm이라고 이름 붙임.
		
}
