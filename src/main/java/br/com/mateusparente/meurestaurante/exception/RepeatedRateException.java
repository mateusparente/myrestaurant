package br.com.mateusparente.meurestaurante.exception;

public class RepeatedRateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -47680573160185624L;

	public RepeatedRateException(String message) {
		super(message);
	}

}