package br.com.logistica.roteirizacao.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}
}
