package sunit.gpio.digital;

import sunit.gpio.DigitalInput;
import sunit.gpio.DigitalOutput;
import sunit.gpio.Driver;

/**
 * The DigitalPin class is the first layer between the driver and the managed
 * layer of interface and classes
 * 
 * @author 10usb
 */
public class DigitalPin implements DigitalInput, DigitalOutput {
	public static final int READ = 0;
	public static final int WRITE = 1;
	
	private Driver driver;
	private int number;
	
	/**
	 * Constructs a DigitalPin from a driver and a pin number
	 * @param driver
	 * @param number
	 */
	public DigitalPin(Driver driver, int number) {
		this.driver = driver;
		this.number = number;
	}
	
	/**
	 * To get the number of the pin
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * To change the mode of the pin
	 * @param mode
	 */
	public void mode(int mode) {
		switch (mode) {
			case READ:
				driver.pinMode(number, Driver.MODE_READ);
			break;
			case WRITE:
				driver.pinMode(number, Driver.MODE_WRITE);
			break;
		}
		
	}
	
	@Override
	public void set(boolean value) {
		driver.digitalWrite(number, value);
	}
	
	@Override
	public boolean get() {
		return driver.digitalRead(number);
	}
}
