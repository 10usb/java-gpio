package sunit.gpio.drivers.wiringpi;

import sunit.gpio.GPIOException;

/**
 * Constructs a driver and initialized the native library, this class should only be constructed once
 * @author 10usb
 */
public class Driver implements sunit.gpio.Driver {
	private boolean userSpace;

	/**
	 * To construct this driver
	 * @param userSpace
	 * @throws GPIOException
	 */
	public Driver(boolean userSpace) throws GPIOException {
		if(!Native.init(userSpace))
			throw new GPIOException("Failed to initialized native library");
		
		this.userSpace = userSpace;
	}

	@Override
	public boolean canChangeMode() {
		return !userSpace;
	}

	@Override
	public void pinMode(int pin, int mode) {
		Native.pinMode(pin, mode);
	}

	@Override
	public void digitalWrite(int pin, boolean value) {
		Native.digitalWrite(pin, value);
	}

	@Override
	public boolean digitalRead(int pin) {
		return Native.digitalRead(pin);
	}

	@Override
	public void analogWrite(int pin, int value) {
		Native.analogWrite(pin, value);
	}

	@Override
	public int analogRead(int pin) {
		return Native.analogRead(pin);
	}
}
