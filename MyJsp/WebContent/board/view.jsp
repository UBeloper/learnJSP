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
	String b_num = request.getParameter("b_num");	//GET 방식에 의한 전송
	
%>
	<h3>상세보기</h3>
	<a href="./list.jsp">리스트</a><br>
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
		query = "select * from tblboard where b_num = ?";
		pstmt = conn.prepareStatement(query);	//쿼리객체 생성
		pstmt.setInt(1, Integer.parseInt(b_num));
		rs = pstmt.executeQuery();	//쿼리 실행해서 결과를 rs에 반환받음
		rs.next();	//첫번째 레코드로 이동(레코드는 단 1개만 검색됨)
		String b_subject = rs.getString("b_subject");
		String b_name = rs.getString("b_name");
		String b_contents = rs.getString("b_contents");
		String b_date = rs.getString("b_date");
		b_contents = b_contents.replace("\n", "<br>");	//치환해서 업데이트
%>
		<table border="1">
		<tr>
			<td align="center" width="150">번호</td>
			<td width="300"><%=b_num%></td>
		</tr>
		<tr>
			<td align="center" width="150">제목</td>
			<td width="300"><%=b_subject%></td>
		</tr>
		<tr>
			<td align="center" width="150">작성자</td>
			<td width="300"><%=b_name%></td>
		</tr>
		<tr>
			<td align="center" width="150">내용</td>
			<td width="300"><%=b_contents%></td>
		</tr>
		<tr>
			<td align="center" width="150">작성일</td>
			<td width="300"><%=b_date%></td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<a href="./update.jsp?b_num=<%=b_num %>">[수정]</a>&nbsp;&nbsp;
				<a href="./delete.jsp?b_num=<%=b_num %>">[삭제]</a>
			</td>
		</tr>
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