<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="jsp/includes/basic.jsp"%>
</head>
<body>
	<%@ include file="jsp/includes/standardHiddenFields.jsp"%>
	<c:set var="baseUrl" value=getOrigen(); />
	<c:set var="urlAction" value="/categoria/listar.do"/>
	<c:redirect url="${baseUrl} + ${urlAction} "/>
</body>
</html>