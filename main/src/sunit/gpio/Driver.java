package sunit.gpio;

/**
 * The most lowest possible access to the GPIO pins
 * 
 * @author 10usb
 */
public interface Driver {
	public static final int MODE_READ = 0;
	public static final int MODE_WRITE = 1;
	
	/**
	 * To check if the driver is able to change the mode of the pins
	 * 
	 * @return true if it's possible
	 */
	boolean canChangeMode();
	
	/**
	 * To change the mode of the pin
	 * 
	 * @param pin  The pin index, This could be an alternative numbering depending
	 *             on the driver
	 * @param mode The mode the pin has to be in
	 */
	void pinMode(int pin, int mode);
	
	/**
	 * To set the pin HIGH or LOW
	 * 
	 * @param pin   The pin index, This could be an alternative numbering depending
	 *              on the driver
	 * @param value true to set the pin HIGH
	 */
	void digitalWrite(int pin, boolean value);
	
	/**
	 * 
	 * 
	 * @param pin The pin index, This could be an alternative numbering depending on
	 *            the driver
	 * @return true when HIGH
	 */
	boolean digitalRead(int pin);
	
	/**
	 * 
	 * 
	 * @param pin   The pin index, This could be an alternative numbering depending
	 *              on the driver
	 * @param value A value in the range of 0-1023 where 1023 is equal to the
	 *              maximum voltage of the pin
	 */
	void analogWrite(int pin, int value);
	
	/**
	 * 
	 * 
	 * @param pin The pin index, This could be an alternative numbering depending on
	 *            the driver
	 * @return A value in the range of 0-1023 where 1023 is equal to the maximum
	 *         voltage of the pin
	 */
	int analogRead(int pin);
}
