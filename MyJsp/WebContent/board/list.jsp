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
	<h3>게시판 리스트</h3>
	<a href="./write.jsp">글쓰기</a><br>
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
		query = "select * from tblboard";
		pstmt = conn.prepareStatement(query);	//쿼리객체 생성
		rs = pstmt.executeQuery();	//쿼리 실행해서 결과를 rs에 반환받음
		//rs 객체는 여러개의 레코드가 포함되어 있을 수 있음(반복구문 필요)
%>
		<table border="1">
			<tr>
				<td align="center" width="100">글번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="150">작성자</td>
				<td align="center" width="150">작성일</td>
			</tr>
<%
		while (rs.next()) {	// 참일 경우 레코드가 반환됨
			int b_num = rs.getInt("b_num");
			String b_subject = rs.getString("b_subject");
			String b_name = rs.getString("b_name");
			String b_date = rs.getString("b_date");
%>			
			<tr>
				<td align="center"><%=b_num %></td>
				<td><a href="./view.jsp?b_num=<%=b_num %>"><%=b_subject %></a></td>
				<td align="center"><%=b_name %></td>
				<td align="center"><%=b_date %></td>
			</tr>
<%			
		}
%>
		</table>
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