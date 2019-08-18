package sunit.gpio.digital;

import java.io.Flushable;
import java.io.IOException;

import sunit.gpio.DigitalOutput;

/**
 * 
 * This class is to wrap around a pin, to make sure that when it's value it set,
 * a call to get it flushed is also triggered
 * 
 * @author 10usb
 */
public class DigitalFlusher implements DigitalOutput {
	private DigitalOutput output;
	private Flushable flushable;
	
	/**
	 * Constructs a DigitalFlusher
	 * @param output	The pin to be wrapped
	 * @param flushable	The instance that needs to be flushed
	 */
	public DigitalFlusher(DigitalOutput output, Flushable flushable) {
		this.output = output;
		this.flushable = flushable;
	}
	
	@Override
	public void set(boolean value) {
		output.set(value);
		
		try {
			flushable.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
