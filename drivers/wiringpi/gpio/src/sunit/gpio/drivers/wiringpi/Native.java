package sunit.gpio.drivers.wiringpi;

/**
 * The native interface to the WiringPi JNI library
 * @author 10usb
 */
public final class Native {
	/**
	 * To initialize the wiringpi library
	 * @param userSpace When true all pins to use need to be exported
	 * @return true on success
	 */
	public static native boolean init(boolean userSpace);
	
	/**
	 * To change the pin mode
	 * @param pin
	 * @param mode
	 */
	public static native void pinMode(int pin, int mode);
	
	/**
	 * To set the state of the pin to HIGH or low
	 * @param pin
	 * @param value
	 */
	public static native void digitalWrite(int pin, boolean value);
	
	/**
	 * To read the state of the pin
	 * @param pin
	 * @return
	 */
	public static native boolean digitalRead(int pin);
	
	/**
	 * To set an analog voltage level
	 * @param pin
	 * @param value
	 */
	public static native void analogWrite(int pin, int value);
	
	/**
	 * To read an analog voltage level
	 * @param pin
	 * @return
	 */
	public static native int analogRead(int pin);
}
