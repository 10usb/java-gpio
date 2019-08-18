package sunit.gpio;

/**
 * This interface represents a digital input pin
 * 
 * @author 10usb
 */
public interface DigitalInput {
	/**
	 * To read a value from the pin
	 * 
	 * @return true if the state of the pin is HIGH
	 */
	boolean get();
}
