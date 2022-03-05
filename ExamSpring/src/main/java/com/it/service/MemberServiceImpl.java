package com.it.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.domain.MemberVO;
import com.it.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MemberServiceImpl implements MemberService {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public MemberVO read(MemberVO member) {
		return mapper.read(member);
	}
	
	@Override
	public void insert(MemberVO member) {
		mapper.insert(member);
	}
	
	@Override
	public void update(MemberVO member) {
		mapper.update(member);
	}
	
	@Override
	public void delete(MemberVO member) {
		mapper.delete(member);
	}

	@Override
	public boolean auth(MemberVO member) {
		// 넘어오는 값 => m_id , m_passwd
		// read메서드를 이용할 수 없으면(m_id가 없어서 메서드 실행값이 null이면)
		MemberVO tmp = new MemberVO();
		tmp = mapper.read(member);
		if(tmp == null) { //아이디가 존재하지 않는다면
			System.out.println("아이디 존재하지 않음"); // 서비스임플에서는 sysout해야 출력됨.
			return false;
			
		} else { // 아이디가 있으면, 패스워드 체크
			
			if(tmp.getM_passwd().equals(member.getM_passwd())) {
				return true;
			
			}else {
				System.out.println("비밀번호가 틀림");
				return false;
			}
		}		
	}
	

	
}
