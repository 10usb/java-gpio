package sunit.gpio;

/**
 * Represent a controller the has digital output pins
 * 
 * @author 10usb
 */
public interface DigitalOutputController {
	/**
	 * To get a DigitalOutput by its index
	 * 
	 * @param index The index number of the digital output
	 * @return An instance or null if it doesn't exists
	 */
	DigitalOutput getDigitalOutput(int index);
}
