package sunit.gpio;

import sunit.gpio.digital.DigitalPin;

/**
 * This class is an adapter between the driver and the DigitalInputController
 * and DigitalOutputController interfaces it implements
 * 
 * @author 10usb
 */
public class DriverController implements DigitalController {
	private Driver driver;
	
	/**
	 * Construct a DriverController
	 * @param driver	The driver
	 */
	public DriverController(Driver driver) {
		this.driver = driver;
	}
	
	/**
	 * To get access to a DigitalPin
	 * @param number The index number of the pin, this could be different depending on the driver
	 * 
	 * @return The DigitalPin
	 */
	public DigitalPin getDigitalPin(int number) {
		return new DigitalPin(driver, number);
	}
	
	@Override
	public DigitalInput getDigitalInput(int index) {
		return getDigitalPin(index);
	}
	
	@Override
	public DigitalOutput getDigitalOutput(int index) {
		return getDigitalPin(index);
	}
}
