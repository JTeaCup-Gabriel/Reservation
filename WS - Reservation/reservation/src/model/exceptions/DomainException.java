package model.exceptions;

public class DomainException extends RuntimeException {
	// Usualmente a exceção herda da super classe "Exception" ou RuntimeException.
	// Exception o compilador obriga a ser tratada, RuntimoException não.
	private static final long serialVersionUID = 1L; // Serial, pois a mesma é uma classe serializavel.

	// Construtor
	public DomainException(String message) {
		super(message);
	}

}
