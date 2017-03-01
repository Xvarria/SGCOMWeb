<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<th>Id</th>
			<th>Codigo</th>
			<th>Descripcion</th>
		</tr>
	<c:forEach items="${lista}" var="cat">
		<tr>
			<td><c:out value="${cat.categoriaId}"/></td>
			<td><c:out value="${cat.codigo}"/></td>
			<td><c:out value="${cat.descripcion}"/></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>