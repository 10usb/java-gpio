# JNI WiringPi
include makefile.in

OUTPUT=bin/wiringpijni
SOURCES=main.c
TEMP=obj
OBJECTS=$(SOURCES:%.c=$(TEMP)/%.o)
TARGET=$(OUTPUT).so
CFLAGS=-fPIC -I../gpio/includes -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/$(JAVA_SYSTEM)"

build: $(TARGET)

clean:
	$(RM) $(TARGET) $(OBJECTS)

$(TARGET): $(OBJECTS) | $(dir $(TARGET))
	$(CC) -shared -Wall -fPIC -lwiringPi -lpthread -o $@ $(OBJECTS) 

$(TEMP)/%.o: src/%.c | $(TEMP)
	$(CC) -c $(CFLAGS) -o $@ $<

$(TEMP) $(dir $(TARGET)):
	$(MKDIR) $@

.PHONY: build clean