package sunit.gpio.digital;

import java.io.Flushable;
import java.io.IOException;

import sunit.gpio.DigitalOutput;

/**
 * This class wraps around a pin, before it passes on the value to be set, it
 * flushes the instance that needs to to stuff before this pin may be set
 */
public class DigitalPreparer implements DigitalOutput {
	private DigitalOutput output;
	private Flushable flushable;
	
	/**
	 * Constructs a DigitalPreparer
	 * @param output	The pin to be wrapped
	 * @param flushable The instance that needs to be flushed
	 */
	public DigitalPreparer(DigitalOutput output, Flushable flushable) {
		this.output = output;
		this.flushable = flushable;
	}
	
	@Override
	public void set(boolean value) {
		try {
			flushable.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		output.set(value);
	}
}
