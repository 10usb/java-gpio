package sunit.gpio.digital;

import sunit.gpio.DigitalOutput;

/**
 * This digital output pin is for debug purpose, as is doesn't actually change
 * the state of a pin, it only print the state it should be changed to on the
 * screen
 * 
 * @author 10usb
 */
public class PrintDigitalOutput implements DigitalOutput {
	private String name;
	
	/**
	 * Constructs a PrintDigitalOutput with a label
	 * @param name The label of the pin
	 */
	public PrintDigitalOutput(String name) {
		this.name = name;
	}
	
	@Override
	public void set(boolean value) {
		System.out.println(name + ": " + (value ? "ON" : "OFF"));
	}
}
