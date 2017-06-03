function getOrigen(){
	if (!window.location.origin) {
  	  origen = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port: '');
  }
  else{
  	origen= window.location.origin;
  }
	return origen +  $('#contextPath').val();
}


function mostrarErrores(){
	var mensajeAlert = "";
	var contador = 0;
	$('[name=error]').each(function() {
		mensajeAlert = mensajeAlert + $(this).val() + '\n';
		contador ++;
	});
	
	//TODO cambiar alert a bootbox
	if (contador > 0){
		var inicio = contador == 1 ? 'Error:\n' : 'Errores:\n';
		alert(inicio + mensajeAlert);
		var formCommand = $("#categoriaForm").attr('commandname');
		var campoConForm = $("input[name='campo.error']:first").val();
		if (formCommand.trim() != '' && campoConForm.trim() != ''){
			var init = campoConForm.indexOf(formCommand);
			if (init >= 0 && campoConForm.length >= formCommand.length + 1){
				fieldId = '#' + campoConForm.substr(init + formCommand.length + 1);
				$(fieldId).focus();
			}
		}
	}
}

//TODO Probablemente requira un parametroParaIndicar el tipo de formulario
function mostrarMensajesOk(){
	var mensaje = $("#mensaje").val();
	if (!(mensaje === '')){
		var AlertMsg = mensaje + '\n';
		var opcion1Etiqueta = $("input[name='opcion1.etiqueta']").val();
		var opcion1Url = $("input[name='opcion1.url']").val();
		var opcion2Etiqueta = $("input[name='opcion2.etiqueta']").val();
		var opcion2Url = $("input[name='opcion2.url']").val();
		mensaje = mensaje + opcion1Etiqueta + ' -> ' + opcion1Url + '\n' + opcion2Etiqueta + ' -> ' + opcion2Url
		accepted = window.confirm(mensaje);
		var accionUrl = ''
		if (accepted) {
	    	accionUrl = getOrigen() +opcion1Url;
	    }else{
	    	accionUrl = getOrigen() +opcion2Url;
	    }
		//Se mueve al URL si el URL no es vacio
	    if (accionUrl != ''){
	    	invocarAccionMetodo(accionUrl, "GET");
	    }
	}
}

function mostrarMensajes(){
	mostrarErrores();
	mostrarMensajesOk();
}

function confirmarYVolvaerALista(){
	alert('Aqui va la confirmacion...');//TODO fill this
	volverALista();
}

function volverALista(){
	accionMetodo('listar','GET');
}

function obtenerGrupoAccion(form){
	var nombreForm = form.attr("name");
	var grupoAccion = '';
	if (nombreForm === 'categoriaForm'){
		grupoAccion = '/categoria/';
	}
	return grupoAccion;
}

function accionMetodo(accion, metodo){
	var accionDo = accion.toLowerCase() + '.do';	
	var form = $("form:first");
	var accionUrl = getOrigen() + obtenerGrupoAccion(form) + accionDo;
	if (!(accionDo === '')){
		invocarAccionMetodo(accionUrl, metodo);
	}else{
		console.error('Error Invocando accion: ' + accionUrl + ' metodo: ' + metodo);	
	}	
}

function invocarAccionMetodo(accionUrl, metodo){
	var form = $("form:first");
	form.prop('action', accionUrl);
	form.prop('method', metodo);
	console.log('Invocando accion: ' + accionUrl + ' metodo: ' + metodo);	
	form.submit();
}
