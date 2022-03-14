package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.MemberVO;
import com.it.mapper.MemberMapper;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public MemberVO read(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.read(member);
	}

	@Override
	public List<MemberVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);
	}

}
