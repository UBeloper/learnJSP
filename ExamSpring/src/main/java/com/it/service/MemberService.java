package com.it.service;

import java.util.List;

import com.it.domain.MemberVO;

public interface MemberService {
	
	public MemberVO read(MemberVO member);
	public List<MemberVO> getList();
	public void insert(MemberVO member);
	public void update(MemberVO member);
	public void delete(MemberVO member);
	
	public boolean auth(MemberVO member);
	
	public int idCheck(MemberVO member);
}
