<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categoria Listar</title>
<%@ include file="./includes/basic.jsp"%>
<script type="text/javascript" src="../js/categoria.js"></script>
</head>
<body>
	<div class="container">TOP</div>
	<div class="container">
		Center
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<table id="CategoriaTable">
					<thead>
						<tr>
							<th>Id</th>
							<th>Codigo</th>
							<th>Descripcion</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

			</div>
		</div>
	</div>
	<div class="container">Bottom</div>
</body>
	<script type="text/javascript">
		$(document).ready(function(){
    		initDatatableOnList();
		});
	</script>
</html>