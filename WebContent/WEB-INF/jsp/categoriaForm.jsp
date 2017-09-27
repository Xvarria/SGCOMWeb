<%@ include file="./includes/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Formulario de Categor&iacute;a</title><!-- Todo agregar selctor din[amico de titulo -->
<%@ include file="./includes/basic.jsp"%>
<script type="text/javascript" src="../js/categoria.js"></script>
</head>
<body>
	<fmt:message key="btn.agregar.categoria" var="btnAgregar"/>
	<fmt:message key="btn.actualizar.categoria" var="btnActualizar"/>
	<fmt:message key="btn.cancelar" var="btnCancelar"/>
	<fmt:message key="btn.atras" var="btnAtras"/>
	
	<form id="categoriaForm" name="categoriaForm" commandName="form" action="./" method="POST">
		<%@ include file="./includes/standardHiddenFields.jsp"%>
		<%@ include file="./includes/standarHiddenFieldsForm.jsp"%>
		
		<!-- ERROR DISPLAY -->
		<div id="mesajesError" class="userError">
			<spring:bind path="form.codigo">
				<c:if test="${!empty status.errorMessages}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
						<input name="error" value="${errorMessage}" type="hidden"/>
					</c:forEach>
					<input name="campo.error" value="${status.path}" type="hidden"/>
				</c:if>
			</spring:bind>
			<spring:bind path="form.descripcion">
				<c:if test="${!empty status.errorMessages}">
					<c:forEach items="${status.errorMessages}" var="errorMessage">
						<input name="error" value="${errorMessage}" type="hidden"/>
					</c:forEach>
					<input name="campo.error" value="${status.path}" type="hidden"/>
				</c:if>
			</spring:bind>	
		</div>
		<!-- END ERROR DISPLAY -->		
		
		<div class="container">
			<div class="row upperSpace">
				<div class="col-md-10 offset-md-1">Upper part goes here</div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.id" />:&nbsp;</div>
				<div class="col-md-8"><input id="categoriaId" name="categoriaId" value="${form.categoriaId}" /></div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.codigo" />:&nbsp;</div>
				<div class="col-md-8"><input id="codigo" name="codigo" value="${form.codigo}" /></div>
			</div>
			<div class="row formRow">
				<div class="col-md-3 offset-md-1 formRigthAlign"><fmt:message key="campo.desc.categoria" />:&nbsp;</div>
				<div class="col-md-8"><input id="descripcion" name="descripcion" value="${form.descripcion}" /></div>
			</div>
			<div class="row">
				<div class="col-md-10 offset-md-1">
					<input id="agregar" type="button" class="intHiddenBtn" value="${btnAgregar}" onclick='accionMetodo("agregar","POST");'/> 
					<input id="actualizar" type="button" class="intHiddenBtn" value="${btnActualizar}" onclick='accionMetodo("actualizar","POST");'/> 
					<input id="cancelar" type="button" class="intHiddenBtn" value="${btnCancelar}" onclick='confirmarYVolvaerALista();'/>
					<input id="atras" type="button" class="intHiddenBtn" value="${btnAtras}" onclick='volverALista();'/>
				</div>
			</div>			
		</div>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		esconderCampos();
		mostrarMensajes();
	});
</script>
</html>
