function testCategoria(){
	alert("Categroia.js");
} 

function initDatatableOnList(){
	$('#CategoriaTable').DataTable({
	    ajax: '../ajaxGetCagetorias.html'
	});
}