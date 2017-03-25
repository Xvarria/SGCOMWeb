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
					return '<a href="' + getOrigen() +'/categoria/detalleCategoria.do?cateforia='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/magnifier.png" width="20" height="20"> </a>';
				}
			}, {
				targets : 4,
				className : 'center',
				orderable : 'false',
				render : function(data, type, full, meta) {
					return '<a href="' + getOrigen() +'/categoria/modificarCategoria.do?cateforia='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/page_edit.png" width="20" height="20"> </a>';
				}
			},{
				targets : 5,
				className : 'center',
				orderable : 'false',
				render : function(data, type, full, meta) {
					return '<a href="' + getOrigen() +'/categoria/eliminarCategoria.do?cateforia='+ full.categoriaId + '"><img border="0" alt="Detalle" src="../images/cross.png" width="20" height="20"> </a>';
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

function agregarCategoria(){
	var form = $("#categoriaListar");
	form.action = getOrigen() +'/categoria/agregar.do';
	form.method = "GET";
	form.submit();
	console.log('sumbmting to: ' + form.action + ' method: ' + form.method);
}
