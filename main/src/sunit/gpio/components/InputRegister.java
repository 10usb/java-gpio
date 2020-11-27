package sunit.gpio.components;

import sunit.gpio.DigitalInput;

/**
 * An class that will turn {@link DigitalInput} pins into a number
 * 
 * @author 10usb
 */
public class InputRegister {
	private DigitalInput[] pins;
	
	/**
	 * Constructs an InputRegister where the pins needs to be in big-endian order
	 * 
	 * @param pins
	 */
	public InputRegister(DigitalInput[] pins) {
		this.pins = pins;
	}
	
	/**
	 * Get a value by reading each pin and constructing a value of it
	 * 
	 * @return
	 */
	public long get() {
		long value = 0;
		
		for (DigitalInput pin : pins) {
			value <<= 1;
			value |= pin.get() ? 1 : 0;
		}
		
		return value;
	}
}
