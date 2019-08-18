package sunit.gpio.digital;

import sunit.gpio.DigitalInput;
import sunit.gpio.DigitalOutput;

/**
 * This class allows to set-up virtual pins, as one instance may write to it as
 * it being an output pin, while an other instance reads from it.
 * 
 * @author 10usb
 */
public class DigitalPipe implements DigitalInput, DigitalOutput {
	private boolean value;
	
	@Override
	public void set(boolean value) {
		this.value = value;
	}
	
	@Override
	public boolean get() {
		return value;
	}
}
