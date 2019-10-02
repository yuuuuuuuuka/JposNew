<%@ page contentType="text/html;charset=UTF-8" %>

<%//Bean利用の指定タグ%>
<jsp:useBean id="topBean" class="Bean.TopBean" scope="request" />
<%
	// PostメソッドでのServletデータ受け取り
	request.setCharacterEncoding("Shift_JIS");
	Integer strServlet = (Integer) request.getAttribute("fromServlet");//ID
	String strServlet2 = (String) request.getAttribute("fromServletn");//name
	String strServlet3 = (String) request.getAttribute("fromServletc");//code

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8" />
<title>test</title>
</head>
<body>


 <!-- Postメソッド ID,name,code-->
<%=strServlet%>
<%=strServlet2%>
<%=strServlet3%>

</body>
</html>