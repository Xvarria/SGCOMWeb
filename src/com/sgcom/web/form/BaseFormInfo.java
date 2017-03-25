package com.sgcom.web.form;

import com.sgcom.web.model.FormAcciones;

public class BaseFormInfo {
	private String accion;

	public BaseFormInfo(FormAcciones formAccion){
		super();
		this.accion = formAccion.getDesc();
	}
	
	public String getAccion() {
		return accion;
	}

	//Setea la acción mediante el enum
	public void setAccion(FormAcciones formAccion) {
		this.accion = formAccion.getDesc();
	}
}
