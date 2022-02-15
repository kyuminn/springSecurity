package com.example.demo.auth.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.auth.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class AuthRepository {
	private Map<Long,MemberDto> store = new HashMap<>();
	private long sequence = 0L;
	
	public void insert(MemberDto memberDto) {
		store.put(++sequence, memberDto);
		log.info("inserted={}",memberDto);
	}
	
	public Optional<MemberDto> selectByEmail(String email) {
		Iterator<Long> iter = store.keySet().iterator();
		MemberDto memberDto = new MemberDto();
		while(iter.hasNext()) {
			Long id = iter.next();
			if(store.get(id).getEmail().equals(email)) {
				memberDto = store.get(id);
			}
		}
		return Optional.ofNullable(memberDto);
	}
}
