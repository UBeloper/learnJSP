package com.it.mapper;

import java.util.List;

import com.it.domain.MemberVO;

public interface MemberMapper {
	
	public List<MemberVO> getList();
	public MemberVO read(MemberVO member);
	public void insert(MemberVO member);
	public void delete(MemberVO member);
	public void update(MemberVO member);
	
	// 회원가입 아이디 중복체크
	public int idCheck(MemberVO member);
	
}
