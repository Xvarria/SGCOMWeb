package com.sgcom.web.form;

import com.sgcom.web.model.FormAcciones;

public class BaseFormInfo {
	private final String accionAgregar = FormAcciones.AGREGAR.getDesc();
	private final String accionActualizar = FormAcciones.ACTUALIZAR.getDesc();
	private final String accionEliminar = FormAcciones.ELIMINAR.getDesc();
	private final String accionMostrar = FormAcciones.MOSTRAR.getDesc();
	private final String accionListar = FormAcciones.LISTAR.getDesc();
	
	private String accion;
	
	public BaseFormInfo(){
		super();
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	//Metodos de para propiedades de solo lectura
	public String getAccionAgregar() {
		return accionAgregar;
	}

	public String getAccionActualizar() {
		return accionActualizar;
	}

	public String getAccionEliminar() {
		return accionEliminar;
	}

	public String getAccionMostrar() {
		return accionMostrar;
	}

	public String getAccionListar() {
		return accionListar;
	}
}
