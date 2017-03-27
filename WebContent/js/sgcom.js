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