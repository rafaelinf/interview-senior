package br.com.brainweb.interview.exception;

public class HeroExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public HeroExistsException() {
	}

	public HeroExistsException(String message) {
		super(message);
	}
}
