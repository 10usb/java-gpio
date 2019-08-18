#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sunit_gpio_drivers_wiringpi_Native.h>
#include <wiringPi.h>


JNIEXPORT jboolean JNICALL Java_sunit_gpio_drivers_wiringpi_Native_init(JNIEnv *env, jclass thiClass, jboolean userSpace){
    if(userSpace == JNI_TRUE){
        wiringPiSetupSys();
    }else{
        wiringPiSetup();
    }
}

JNIEXPORT void JNICALL Java_sunit_gpio_drivers_wiringpi_Native_pinMode(JNIEnv *env, jclass thiClass, jint pin, jint mode){
    pinMode(pin, mode ? OUTPUT : INPUT);
}

JNIEXPORT void JNICALL Java_sunit_gpio_drivers_wiringpi_Native_digitalWrite(JNIEnv *env, jclass thiClass, jint pin, jboolean value){
    digitalWrite(pin, value == JNI_TRUE ? HIGH : LOW);
}

JNIEXPORT jboolean JNICALL Java_sunit_gpio_drivers_wiringpi_Native_digitalRead(JNIEnv *env, jclass thiClass, jint pin){
    return digitalRead(pin) == HIGH ? JNI_TRUE : JNI_FALSE;
}

JNIEXPORT void JNICALL Java_sunit_gpio_drivers_wiringpi_Native_analogWrite(JNIEnv *env, jclass thiClass, jint pin, jint value){
    analogWrite(pin, value);
}

JNIEXPORT jint JNICALL Java_sunit_gpio_drivers_wiringpi_Native_analogRead(JNIEnv *env, jclass thiClass, jint pin){
    return analogRead(pin);
}
