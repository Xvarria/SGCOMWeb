package com.sgcom.web.model;

public enum FormAcciones {
	LISTAR("LISTAR"),
	AGREGAR("AGREGAR"),
	ACTUALIZAR("ACTUALIZAR"),
	ELIMINAR("ELIMINAR"),
	MOSTRAR("MOSTRAR");
	
	public String desc;
	
	private FormAcciones(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public static FormAcciones getAccion(String desc){
		if (desc != null) {
			for (FormAcciones accion : FormAcciones.values()) {
				if (desc.equals(accion.getDesc())) {
					return accion;
				}
			}
		}
		return null;
	}
}
