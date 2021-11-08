package member.persistence;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.domain.MemberDTO;
import member.domain.UpdateDTO;

import static member.persistence.JdbcUtil.*;


public class MemberDAO {
	private Connection con;
	

	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	
	
	
	// login  => select
	public MemberDTO isLogin(String userid, String password) {
		MemberDTO loginDto = null;
		
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		
		try {
			String sql = "select userid,name from member where userid=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();//조회하는 것만 쿼리문
			if(rs.next()) {
				loginDto = new MemberDTO();
				loginDto.setUserid(rs.getString(1)); //결과값을 보여줘라(rs)
				loginDto.setName(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
	
	return loginDto;
	
	}
	
	
	//회원탈퇴
	public boolean delete(String userid, String password) {
		boolean deleteFlag = false; //boolean은 비교 연산자이므로 값에 따라 판단됨
				
	    PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from member where userid=? and password=?";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);    
			pstmt.setString(2, password);
		
			int result = pstmt.executeUpdate();//sql 반환값이 정수 개념으로 반환받겠다라는 의미,
			
			if(result>0) deleteFlag = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return deleteFlag;
	}
	
	// 수정하기 
	public boolean update(UpdateDTO updateDto) {//UpdateDTO	updateDto
		boolean updateFlag = false;
		
		PreparedStatement pstmt = null;// 가장 기본 값이므로 무조건 부여
		
		try {
			String sql = "update member set password=? where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, updateDto.getNew_password());//set은 없으니까 쓸려고 할때, get은 있는 걸 쓸때 
			pstmt.setString(2, updateDto.getUserid());
			pstmt.setString(3, updateDto.getCurrent_password());
		
			int result = pstmt.executeUpdate();
			
			if (result>0) updateFlag = true;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	return updateFlag;
	}
	
	
}
