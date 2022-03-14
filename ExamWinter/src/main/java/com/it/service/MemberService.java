package com.it.service;

import java.util.List;

import com.it.domain.MemberVO;

public interface MemberService {
	
	public MemberVO read(MemberVO member); //단일 레코드 조회
	
	public List<MemberVO> getList();  // 전체 레코드 조회
	
	public void delete(MemberVO member); //레코드 삭제

}
