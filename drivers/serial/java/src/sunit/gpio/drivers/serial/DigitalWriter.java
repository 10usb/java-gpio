package sunit.gpio.drivers.serial;

import java.io.IOException;
import java.io.Writer;

import sunit.gpio.digital.DigitalChange;
import sunit.gpio.digital.DigitalTrigger;

public class DigitalWriter extends DigitalTrigger implements DigitalChange {
	private Writer writer;
	private char character;
	
	public DigitalWriter(Writer writer, boolean initialValue, char character) {
		super(null, initialValue);
		this.writer = writer;
		this.character = character;
		setHandler(this);
	}
	
	@Override
	public void onChange(boolean value) {
		if (value) {
			try {
				writer.append(character);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
