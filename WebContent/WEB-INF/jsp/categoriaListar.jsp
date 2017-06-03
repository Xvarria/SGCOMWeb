<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categor&iacute;a Listar</title>
<%@ include file="./includes/basic.jsp"%>
<script type="text/javascript" src="../js/categoria.js"></script>
</head>
<body>
	<form id="categoriaForm" name="categoriaForm">
		<%@ include file="./includes/standardHiddenFields.jsp"%>
		<div class="container">
			<div class="row upperSpace">
				<div class="col-md-10 offset-md-1">
					<fmt:message key="btn.agregar.categoria" var="btnLabel"/>
					<input type="button" value="${btnLabel}" onclick='accionMetodo("agregar","GET");'/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-10 offset-md-1">
					<table id="CategoriaTable">
						<thead>
							<tr>
								<th><fmt:message key="campo.id"/></th>
								<th><fmt:message key="campo.codigo"/></th>
								<th><fmt:message key="campo.desc.categoria"/></th>
								<th><fmt:message key="encabezado.detalle"/></th>
								<th><fmt:message key="encabezado.editar"/></th>
								<th><fmt:message key="encabezado.eliminar"/></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(){
   		initDatatableOnList();
	});
</script>
</html>
