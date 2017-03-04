function getOrigen(){
	if (!window.location.origin) {
  	  origen = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port: '');
  }
  else{
  	origen= window.location.origin;
  }
	return origen +  $('#contextPath').val();
}
