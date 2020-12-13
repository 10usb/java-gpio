#define PIN_SHIFT 16
#define PIN_DATA  12
#define PIN_LATCH 14
#define PIN_WRITE 5
#define DELAY 1

void setup() {
  Serial.begin(115200); 
  pinMode(PIN_SHIFT, OUTPUT);
  pinMode(PIN_DATA, OUTPUT);
  pinMode(PIN_LATCH, OUTPUT);
  pinMode(PIN_WRITE, OUTPUT);
  digitalWrite(PIN_WRITE, HIGH);
}

void loop() {
  int value = 0;
  if (Serial.available() > 0) {
    value = Serial.read();

    switch(value){
      case '0': shift(LOW); break;
      case '1': shift(HIGH); break;
      case 'L': latch(); break;
      case 'W': pulse_write(); break;
    }
  }
}

void set(int pin, int value){
  digitalWrite(pin, value);
  delayMicroseconds(DELAY);
}

void shift(int value){
  digitalWrite(PIN_DATA, value);
  digitalWrite(PIN_SHIFT, HIGH);
  delayMicroseconds(DELAY);
  digitalWrite(PIN_SHIFT, LOW);
  delayMicroseconds(DELAY);
}

void latch(){
  digitalWrite(PIN_LATCH, HIGH);
  delayMicroseconds(DELAY);
  digitalWrite(PIN_LATCH, LOW);
}

void pulse_write(){
  digitalWrite(PIN_WRITE, LOW);
  delayMicroseconds(DELAY);
  digitalWrite(PIN_WRITE, HIGH);
}
