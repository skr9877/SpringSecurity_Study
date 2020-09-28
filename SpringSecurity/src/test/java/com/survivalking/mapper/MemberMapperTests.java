package com.survivalking.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.survivalking.domain.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberMapperTests {
	@Autowired
	private MemberMapper mapper;
	
	@Test
	public void testRead() {
		MemberVO vo = mapper.read("admin");
		
		log.info(vo);
		
		vo.getAuthList().forEach(item ->{
			log.info(item);
		});
	}
}
