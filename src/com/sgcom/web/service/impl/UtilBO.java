package com.sgcom.web.service.impl;

import com.sgcom.web.model.exception.ParametroIncorrectoException;

public final class UtilBO {
	
	/**
	 * 
	 * @param valorStr
	 * @return
	 * @throws ParametroIncorrectoException
	 */
	public static int getIntParametro(String valorStr) throws ParametroIncorrectoException{
		try {
			int valorInt = Integer.parseInt(valorStr);
			return valorInt;
		} catch (Exception e) {
			throw new ParametroIncorrectoException();
		}
	};

}
