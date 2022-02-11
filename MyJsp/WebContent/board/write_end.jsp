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
	String b_subject = request.getParameter("b_subject");
	String b_name = request.getParameter("b_name");
	String b_contents = request.getParameter("b_contents");
	out.print(b_subject + ":" + b_name + ":" + b_contents);
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
		query = "insert into tblboard (b_subject, b_name, b_contents) values (?, ?, ?)";
		pstmt = conn.prepareStatement(query);	//쿼리객체 생성
		pstmt.setString(1, b_subject);
		pstmt.setString(2, b_name);
		pstmt.setString(3, b_contents);
		pstmt.executeUpdate();	// insert, update, delete 의 경우 사용
%>
		<script>
			alert("입력되었습니다.");
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