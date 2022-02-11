<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String b_num = request.getParameter("b_num");
%>
<%
	Connection conn = null;	//접속 객체 선언
	PreparedStatement pstmt = null;  //쿼리객체 선언
	ResultSet rs = null;	//쿼리결과(레코드집합) 객체 선언
	String query = "";	//SQL 문법 선언
	try {
		Class.forName("com.mysql.jdbc.Driver"); //JDBC 드라이버 로드
		//out.print("드라이버 로드 성공");
		String url = "jdbc:mysql://localhost:3306/mysql";	//접속url
		String user = "root";
		String passwd = "";
		conn = DriverManager.getConnection(url, user, passwd); //디비에 연결(conn객체 생성)
		//out.print(conn);
		query = "delete from tblboard where b_num = ?";
		pstmt = conn.prepareStatement(query);	//쿼리객체 생성
		pstmt.setInt(1, Integer.parseInt(b_num));
		pstmt.executeUpdate();	// insert, update, delete 의 경우 사용
%>
		<script>
			alert("삭제되었습니다.");
			location.href = "./list.jsp";
		</script>	
<%
	} catch (Exception e) {
		out.print(e);
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
			out.print(ex);
		}
	}
%>
</body>
</html>