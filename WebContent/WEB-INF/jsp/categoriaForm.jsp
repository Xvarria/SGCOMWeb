<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categoria Agregar</title>
<%@ include file="./includes/basic.jsp"%>
<script type="text/javascript" src="../js/categoria.js"></script>
</head>
<body>
	<form id="categoriaListar" commandName="form" action="./" method="POST">
		<%@ include file="./includes/standardHiddenFields.jsp"%>
		<%@ include file="./includes/standarHiddenFieldsForm.jsp"%>
		<div class="container">
			<div class="row upperSpace">
				<div class="col-md-10 offset-md-1">Upper part goes here</div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.id" />:&nbsp;</div>
				<div class="col-md-8"><input id="categoria.categoriaId" value="${form.categoria.categoriaId}" /></div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.codigo" />:&nbsp;</div>
				<div class="col-md-8"><input id="categoria.codigo" value="${form.categoria.codigo}" /></div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.desc.categoria" />:&nbsp;</div>
				<div class="col-md-8"><input id="categoria.descripcion" value="${form.categoria.descripcion}" /></div>
			</div>
			<div class="row">
				<div class="col-md-10 offset-md-1">buttons goes here</div>
			</div>			
		</div>
	</form>
</body>
</html>
