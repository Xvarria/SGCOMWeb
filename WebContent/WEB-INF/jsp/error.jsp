<%@ include file="./includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<%@ include file="./includes/basic.jsp"%>
<script type="text/javascript" src="../js/categoria.js"></script>
</head>
<body>
	<fmt:message key="${mensajeError}" var="mensaje"/>
	
	<form id="errorForm" action="./" method="POST">		
		<div class="container">
			<div class="row upperSpace">
				<div class="col-md-10 offset-md-1"><c:out value="${mensaje}"/></div>
			</div>
		</div>
	</form>
</body>
</html>
