package sunit.gpio.drivers.serial;

import java.io.IOException;
import java.io.Writer;

import sunit.gpio.DigitalOutput;
import sunit.gpio.digital.DigitalChange;
import sunit.gpio.digital.DigitalPipe;
import sunit.gpio.digital.DigitalTrigger;

public class ShiftWriter {
	private Writer writer;
	private DigitalPipe data;
	private DigitalOutput shift;
	private DigitalOutput latch;
	
	public ShiftWriter(Writer writer) {
		this.writer = writer;
		data = new DigitalPipe();
		shift = new DigitalTrigger(new ShiftChange());
		latch = new DigitalTrigger(new LatchChange());
	}
	
	public DigitalOutput getData() {
		return data;
	}
	
	public DigitalOutput getShift() {
		return shift;
	}
	
	public DigitalOutput getLatch() {
		return latch;
	}
	
	public class ShiftChange implements DigitalChange {
		@Override
		public void onChange(boolean value) {
			if(value) {
				try {
					writer.append(data.get() ? '1' : '0');
				} catch (IOException e) {
					// TODO let it flow
					e.printStackTrace();
				}
			}
		}
	}
	
	public class LatchChange implements DigitalChange {
		@Override
		public void onChange(boolean value) {
			if(value) {
				try {
					writer.append('L');
				} catch (IOException e) {
					// TODO let it flow
					e.printStackTrace();
				}
			}
		}
	}
}
