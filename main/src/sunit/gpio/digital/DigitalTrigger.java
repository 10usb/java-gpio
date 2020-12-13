package sunit.gpio.digital;

import sunit.gpio.DigitalOutput;

/**
 * 
 * @author 10usb
 */
public class DigitalTrigger implements DigitalOutput {
	private DigitalChange handler;
	private boolean currentValue;
	
	public DigitalTrigger(DigitalChange handler) {
		this(handler, false);
	}
	
	public DigitalTrigger(DigitalChange handler, boolean initialValue) {
		this.handler = handler;
		this.currentValue = initialValue;
	}
	
	protected void setHandler(DigitalChange handler) {
		this.handler = handler;
	}
	
	@Override
	public void set(boolean value) {
		if (value != currentValue) {
			currentValue = value;
			handler.onChange(value);
		}
	}
}
