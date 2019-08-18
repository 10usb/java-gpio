package sunit.gpio;

/**
 * Represent a controller the has digital input pins
 * 
 * @author 10usb
 */
public interface DigitalInputController {
	/**
	 * To get a DigitalInput by its index
	 * 
	 * @param index The index number of the digital input
	 * @return An instance or null if it doesn't exists
	 */
	DigitalInput getDigitalInput(int index);
}
