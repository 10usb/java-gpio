package sunit.gpio.components;

import sunit.gpio.DigitalOutput;

/**
 * An class that will transforms a number into setting {@link DigitalOutput}
 * pins
 * 
 * @author 10usb
 */
public class OutputRegister {
	private DigitalOutput[] pins;
	
	/**
	 * Constructs an OutputRegister where the pins need to be in little-endianness
	 * order
	 * 
	 * @param pins
	 */
	public OutputRegister(DigitalOutput[] pins) {
		this.pins = pins;
	}
	
	/**
	 * Set a numeric value to the pins
	 * 
	 * @param value
	 */
	public void set(long value) {
		for (DigitalOutput pin : pins) {
			pin.set((value & 1) == 1);
			value >>= 1;
		}
	}
}
