package com.survivalking.security;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
@Log4j
public class MemberTests {
	@Autowired
	private PasswordEncoder encoder;
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource ds;
	
	//@Test
	public void testMember() {
		String sql = "insert into tbl_member(userid, userpw, username) values(?,?,?)";
		
		
		
		for(int i =0; i < 10; ++i) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(2, encoder.encode("pw" + i));
				
				if(i < 5) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반사용자" + i);
				}
				else if(i < 9) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "운영자" + i);
				}
				else {
					pstmt.setString(1, "admin");
					pstmt.setString(3, "관리자");
				}
				
				pstmt.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(pstmt != null) try {pstmt.close();} catch (SQLException e) { e.printStackTrace();}
				if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
			}
		}
	}
	
	@Test
	public void testMemberAuth() {
			String sql = "insert into tbl_member_auth(userid, auth) values(?,?)";
			
			
			
			for(int i =0; i < 10; ++i) {
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				try {
					conn = ds.getConnection();
					pstmt = conn.prepareStatement(sql);

					
					if(i < 5) {
						pstmt.setString(1, "user" + i);
						pstmt.setString(2, "ROLE_USER");
					}
					else if(i < 9) {
						pstmt.setString(1, "manager" + i);
						pstmt.setString(2, "ROLE_MEMBER");
					}
					else {
						pstmt.setString(1, "admin");
						pstmt.setString(2, "ROLE_ADMIN");
					}
					
					pstmt.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				finally {
					if(pstmt != null) try {pstmt.close();} catch (SQLException e) { e.printStackTrace();}
					if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
				}
			}
		}
}
