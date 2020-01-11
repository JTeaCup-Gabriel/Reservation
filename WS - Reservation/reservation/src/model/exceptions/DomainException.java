package model.exceptions;

public class DomainException extends RuntimeException {
	// Usualmente a exce��o herda da super classe "Exception" ou RuntimeException.
	// Exception o compilador obriga a ser tratada, RuntimoException n�o.
	private static final long serialVersionUID = 1L; // Serial, pois a mesma � uma classe serializavel.

	// Construtor
	public DomainException(String message) {
		super(message);
	}

}
