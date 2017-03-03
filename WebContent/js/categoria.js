function initDatatableOnList(){
	categoriaTableInit=false;
	cTable=null;
	//refreshCategoriaTable();

	//Change to new ajax
	//AjaxController.refreshFamilyPage({callback:populateCategoriaTable, errorHandler:exceptionHandler});
	$.ajax('../ajaxGetCagetorias.html',{
		success: function(data) {
			refreshCategoriaTable(data)
		},
		error: function(){
			exceptionHandler
		}
	});

//	 $('#CategoriaTable').DataTable();
}

function exceptionHandler(){
	refreshFamilyPageTable([]);
	alert('Error')
}


function refreshCategoriaTable(object) {
console.log("START refreshCategoriaTable");
if (categoriaTableInit == false) {
	categoriaTableInit = true;
	cTable = $('#CategoriaTable').DataTable({
		data : object
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

/*function refreshCategoriaTable(object) {
	console.log("START refreshCategoriaTable");
	if (categoriaTableInit == false) {
		categoriaTableInit = true;
		cTable = $('#CategoriaTable').DataTable({
			data : object,
			columns : [ {
				data : 'Id'
			}, {
				data : 'Codigo'
			}, {
				data : 'Descripcion'
			}, {
				data : null,
				orderable : false
			}, {
				data : null,
				orderable : false
			}],
			columnDefs : [ {
				targets : 0,
				className : 'right'
			}, {
				targets : [1, 2, 3, 4],
				className : 'center'
			}],
			language: {emptyTable: 'Categorias no encontradas'},
			pagingType : 'simple',
			order : [ [ 1, 'asc' ] ],
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
}*/
