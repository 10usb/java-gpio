package sunit.gpio;

/**
 * This interface represent a digital output pin
 * 
 * @author 10usb
 */
public interface DigitalOutput {
	/**
	 * To set the value of the pin HIGH or LOW
	 * 
	 * @param value true is HIGH
	 */
	void set(boolean value);
}
