package com.sgcom.web.form;

import com.sgcom.web.model.FormAcciones;

public class BaseFormInfo {
	private final String accionAgregar = FormAcciones.AGREGAR.getDesc();
	private final String accionActualizar = FormAcciones.ACTUALIZAR.getDesc();
	private final String accionEliminar = FormAcciones.ELIMINAR.getDesc();
	private final String accionMostrar = FormAcciones.MOSTRAR.getDesc();
	private final String accionListar = FormAcciones.LISTAR.getDesc();
	private String mensaje = "";
	private ElementoLink opcion1 = new ElementoLink("", ""); //TODO add new empty cunstructor
	private ElementoLink opcion2 = new ElementoLink("", "");
	
	
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public ElementoLink getOpcion1() {
		return opcion1;
	}

	public void setOpcion1(ElementoLink opcion1) {
		this.opcion1 = opcion1;
	}

	public ElementoLink getOpcion2() {
		return opcion2;
	}

	public void setOpcion2(ElementoLink opcion2) {
		this.opcion2 = opcion2;
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
