<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="helper.*"%>
<%
	Filename fn = new Filename();
	String id = (String) session.getAttribute("id");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XBDPL Compiler</title>
</head>
<body>
	<br />
	<br />

	<form action="/IDE/WaitServlet" method="post">
		<table border="0" align="center" width=70%>
			<tr>
				<td><center>
						<img src="Styles/logo.png" />
					</center></td>
			</tr>
			<tr>
				<td><center>
						<center><h5>IDE version: 0.92 alpha<br />Kernel version: 0.9 alpha</h5></center>
					</center></td>
			</tr>
			<tr>
				<td><center>
						<textarea style="width: 90%; height: 500px" name="sourceCode"></textarea>
					</center></td>
			</tr>

			<tr>
				<td><center>
						<%
							if (id == null) {
						%>
						<input type="text" value="<%=fn.getFilename()%>" name="id" style="display:none"/>
						<%
							} else {
						%>
						<input type="text" value="<%=id%>" name="id" style="display:none"/>
						<%
							}
						%>
						<input type="submit" value="Compile" />
					</center></td>
			</tr>

		</table>
	</form>
</body>
</html>