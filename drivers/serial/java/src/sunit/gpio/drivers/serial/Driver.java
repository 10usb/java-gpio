package sunit.gpio.drivers.serial;

import sunit.gpio.GPIOException;

/**
 * Constructs a driver and initialized the native library, this class should
 * only be constructed once
 * 
 * @author 10usb
 */
public class Driver implements sunit.gpio.Driver {
	/**
	 * To construct this driver
	 * 
	 * @param userSpace
	 * @throws GPIOException
	 */
	public Driver() throws GPIOException {
	}
	
	@Override
	public boolean canChangeMode() {
		return false;
	}
	
	@Override
	public void pinMode(int pin, int mode) {
	}
	
	@Override
	public void digitalWrite(int pin, boolean value) {
	}
	
	@Override
	public boolean digitalRead(int pin) {
		return false;
	}
	
	@Override
	public void analogWrite(int pin, int value) {
		throw new RuntimeException("Not implemented");
	}
	
	@Override
	public int analogRead(int pin) {
		throw new RuntimeException("Not implemented");
	}
}
