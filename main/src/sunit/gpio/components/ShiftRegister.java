package sunit.gpio.components;

import java.io.Flushable;

import sunit.gpio.DigitalOutput;
import sunit.gpio.DigitalOutputController;

public class ShiftRegister implements DigitalOutputController, Flushable {
	private boolean[] bits;
	private DigitalOutput data;
	private DigitalOutput shift;
	private DigitalOutput latch;
	private boolean dirty;
	
	public ShiftRegister(int bits, DigitalOutput data, DigitalOutput shift, DigitalOutput latch) {
		this.bits = new boolean[bits];
		this.data = data;
		this.shift = shift;
		this.latch = latch;
		dirty = true;
	}
	
	public void set(int index, boolean value) {
		synchronized (bits) {
			if(bits[index] != value) {
				bits[index] = value;
				dirty = true;
			}
		}
	}
	
	public void flush() {
		synchronized (bits) {
			if (dirty) {
				for (int index = bits.length - 1; index >= 0; index--) {
					// First prepare the data pin
					data.set(bits[index]);
					
					// Now shift in the bit
					shift.set(true);
					shift.set(false);
				}
				
				// Now latch the set bits to the output
				if (latch != null) {
					latch.set(true);
					latch.set(false);
				}
				dirty = false;
			}	
		}
	}
	
	@Override
	public DigitalOutput getDigitalOutput(int index) {
		return new Pin(index);
	}
	
	private class Pin implements DigitalOutput {
		private int index;
		
		public Pin(int index) {
			this.index = index;
		}
		
		@Override
		public void set(boolean value) {
			ShiftRegister.this.set(index, value);
		}
	}
}
