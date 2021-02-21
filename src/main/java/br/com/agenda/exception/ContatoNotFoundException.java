package br.com.agenda.exception;

public class ContatoNotFoundException extends RuntimeException {

	public ContatoNotFoundException(String message) {
		super(message);
	}
}
