/**
 * Exception class for access in empty containers such as stacks, queues, and
 * priority queues.
 * 
 * @author Mark Allen Weiss
 */
@SuppressWarnings("serial")
class UnderflowException extends RuntimeException {
	// Constructors
	public UnderflowException() {
	}

	public UnderflowException(String message) {
		super(message);
	}
}