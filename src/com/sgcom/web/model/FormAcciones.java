package com.sgcom.web.model;

public enum FormAcciones {
	LISTAR("LISTAR"),
	AGREGAR("AGREGAR"),
	ACTUALIZAR("ACTUALIZAR"),
	ELIMINAR("ELIMIONAR");
	
	public String desc;
	
	private FormAcciones(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
}
