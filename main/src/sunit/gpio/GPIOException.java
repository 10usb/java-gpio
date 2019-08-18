package sunit.gpio;

/**
 * An exception to be used throw from classes within this library
 * 
 * @author 10usb
 */
@SuppressWarnings("serial")
public class GPIOException extends Exception {
	/**
	 * Constructs a GPIOException with a message
	 * 
	 * @param message The message
	 */
	public GPIOException(String message) {
		super(message);
	}
	
	/**
	 * Constructs a GPIOException with a message and an inner exception
	 * @param message  The message
	 * @param throwable The exception that was caught
	 */
	public GPIOException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
