package ch.desm.middleware.modules.communication.controller;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class SerialportReader implements SerialPortEventListener {
	 
	private static SerialPort serialPort;
	
    public void serialEvent(SerialPortEvent event) {
        //Object type SerialPortEvent carries information about which event occurred and a value.
        //For example, if the data came a method event.getEventValue() returns us the number of bytes in the input buffer.
        
    	System.out.println("serialEvent occured");
    	
    	if(event.isRXCHAR()){
            if(event.getEventValue() == 10){
                try {
                    byte buffer[] = serialPort.readBytes(10);
                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
        //If the CTS line status has changed, then the method event.getEventValue() returns 1 if the line is ON and 0 if it is OFF.
        else if(event.isCTS()){
            if(event.getEventValue() == 1){
                System.out.println("CTS - ON");
            }
            else {
                System.out.println("CTS - OFF");
            }
        }
        else if(event.isDSR()){
            if(event.getEventValue() == 1){
                System.out.println("DSR - ON");
            }
            else {
                System.out.println("DSR - OFF");
                }
            }
        }
}
