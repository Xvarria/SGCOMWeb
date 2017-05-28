function initDatatableOnList(){
	categoriaTableInit=false;
	cTable=null;
	$.ajax('../ajaxGetCagetorias.do',{
		success: function(data) {
			refreshCategoriaTable(data)
		},
		error: function(){
			exceptionHandler
		}
	});
}

function exceptionHandler(){
	refreshFamilyPageTable([]);
	alert('Error')
}

function refreshCategoriaTable(data) {
	console.log("START refreshCategoriaTable");
	var object = JSON.parse(data);
	if (categoriaTableInit == false) {
		categoriaTableInit = true;
		cTable = $('#CategoriaTable').DataTable({
			data : object,
			columns : [ {
				data : 'categoriaId'
			}, {
				data : 'codigo'
			}, {
				data : 'descripcion'
			}, {
				data : null,
				orderable : false
			}, {
				data : null,
				orderable : false
			}],
			columnDefs : [ {
				targets : 3,
				className : 'center',
				orderable : 'false',
				render : function(data, type, full, meta) {
					return '<a href="' + getOrigen() +'/categoria/mostrar.do?categoriaId='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/magnifier.png" width="20" height="20"> </a>';
				}
			}, {
				targets : 4,
				className : 'center',
				orderable : 'false',
				render : function(data, type, full, meta) {
					return '<a href="' + getOrigen() +'/categoria/actualizar.do?categoriaId='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/page_edit.png" width="20" height="20"> </a>';
				}
			},{
				targets : 5,
				className : 'center',
				orderable : 'false',
				render : function(data, type, full, meta) {
					return '<a href="' + getOrigen() +'/categoria/eliminar.do?categoriaId='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/cross.png" width="20" height="20"> </a>';
				}
			}],
			language: {emptyTable: 'Categorias no encontradas'},
			order : [ [ 0, 'asc' ] ],
			lengthMenu : [ [ 25, 50,  100, -1 ], [ 25, 50, 100, "All" ] ],
			iDisplayLength : 25
		});
		$('#CategoriaTable').show();
		console.log("INIT refreshCategoriaTable");
	} else {
		cTable.clear().draw();
		for (var i = 0; i < object.length; ++i) {
			cTable.row.add(object[i]).draw();
		}
		console.log("REFRESH refreshCategoriaTable");
	}
	console.log("FINISH refreshCategoriaTable");
}


//TODO crear metodo accion categoria, basado en el 
function accionMetodo(method){
	//TODO usar form name para determinar el dominio
	//TODO extraer metodo a JS general
	//TODO importante si la accion no esta definida los valores de esAgregar esActualizar esMostrar se convierten en true, mejar esto
	//TODO agregarParametro de Accion de maenra que se concatene para obtener el valor por ej. accion actualizar -> buscar por accion "accionActualizar"
	var form = $("#categoriaForm");
	var accionActual = $("#accion").val();
	var accionAgregar = $("#accionAgregar").val();
	var accionMostrar = $("#accionMostrar").val();
	var accionActualizar = $("#accionActualizar").val();
	
	var esAgregar = accionActual == accionAgregar;
	var esMostrar = accionActual == accionMostrar;
	var esActualizar = accionActual == accionActualizar;
	var accionDo = '';
	
	if (esAgregar || esActualizar){
		accionDo = accionActual.toLowerCase() + '.do';	
	}
	
	var accionUrl = getOrigen() +'/categoria/' + accionDo;
	if (!(accionDo === '')){
		form.prop('action', accionUrl);
		form.prop('method', method);
		console.log('Invocando accion: ' + accionUrl + ' metodo: ' + method);	
		form.submit();
	}else{
		console.error('Error Invocando accion: ' + accionUrl + ' metodo: ' + method);	
	}
		
}

function esconderCampos(){
	var accionActual = $("#accion").val();
	var accionAgregar = $("#accionAgregar").val();
	var accionMostrar = $("#accionMostrar").val();
	var accionActualizar = $("#accionActualizar").val();
	
	var esAgregar = accionActual == accionAgregar;
	var esMostrar = accionActual == accionMostrar;
	var esActualizar = accionActual == accionActualizar;
	
	$("#categoriaId").prop("readonly","true");	
	if (esAgregar){
		//Esconde el Id
		$("#categoriaId").attr("hidden");
		//muestra el botón de agergar
		$("#agregar").switchClass("intHiddenBtn", "visibleBtn");
		$("#cancelar").switchClass("intHiddenBtn", "visibleBtn");		
	}
	if (esMostrar){
		$("#codigo").prop("readonly","true");
		$("#descripcion").prop("readonly","true");
		$("#atras").switchClass("intHiddenBtn", "visibleBtn");
	}
	if (esActualizar){
		$("#actualizar").switchClass("intHiddenBtn", "visibleBtn");
		$("#cancelar").switchClass("intHiddenBtn", "visibleBtn");
	}
}
