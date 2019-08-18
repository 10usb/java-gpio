package sunit.gpio.digital;

import sunit.gpio.DigitalInput;
import sunit.gpio.DigitalOutput;

/**
 * This class can be set before the actual pin to invert the signal
 * 
 * @author 10usb
 */
public class DigitalInverter implements DigitalInput, DigitalOutput {
	private DigitalInput input;
	private DigitalOutput output;
	
	/**
	 * Constructs a DigitalInverter as an input
	 * 
	 * @param input The input the signal has to be inverted of
	 */
	public DigitalInverter(DigitalInput input) {
		this.input = input;
	}
	
	/**
	 * Constructs a DigitalInverter a an output
	 * 
	 * @param output The output the signal has to be inverted to
	 */
	public DigitalInverter(DigitalOutput output) {
		this.output = output;
	}
	
	@Override
	public boolean get() {
		return !input.get();
	}
	
	@Override
	public void set(boolean value) {
		output.set(!value);
	}
}
