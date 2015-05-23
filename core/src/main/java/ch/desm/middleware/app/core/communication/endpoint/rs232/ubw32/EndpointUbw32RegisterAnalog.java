package ch.desm.middleware.app.core.communication.endpoint.rs232.ubw32;

import java.util.LinkedList;


public class EndpointUbw32RegisterAnalog extends EndpointUbw32RegisterBase {

	public static final int MAX_DISCRET_VALUE = 1023;
	
	private String pinBitMask;
	private LinkedList<String> valueList;
	
	public EndpointUbw32RegisterAnalog(){
		pinBitMask = "";
		valueList = new LinkedList<String>();
	}
	
	public EndpointUbw32RegisterAnalog(String pinBitMask){
		this.pinBitMask = pinBitMask;
		valueList = new LinkedList<String>();
	}
		
	public void addValue(String value){
		this.valueList.add(value);
	}
	
	public String getAverageValue(){
		if(valueList.isEmpty()){
			return "0";
		}
		
		int average = 0;
		for(String value : valueList){
			average += Integer.valueOf(value);
		}
		average = (average/valueList.size());
		return String.valueOf(average);
	}
	
	public void resetValue(){
		valueList.clear();
	}
	
	public void setPinBitMask(String pinBitMask){
		this.pinBitMask = pinBitMask;
	}
	
	public String getPinBitMask(){
		return pinBitMask;
	}

	public String ToString(){
		String s="";
		s+="pinBitMask :" + pinBitMask;
		s+=", ";
		s+="value :" + valueList;
		
		return s;
	}
}
