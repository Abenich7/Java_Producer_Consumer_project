package test;

import java.util.Date;


public final class Message {

	public final byte[] data;
	public final String asText;
	public final double asDouble;
	public String topic;
	public final Date date;
	
	
	public Message(String msg) {
		
		this.asText=msg;
		this.data=msg.getBytes(); // String -> byte array
		
		double tempDouble;
		try {
			tempDouble=Double.parseDouble(msg); // String -> double
		}catch(NumberFormatException e)
		{
			tempDouble=Double.NaN;
		}
		
		this.asDouble=tempDouble;
		
		this.date=new Date();
	}
	
	
	public Message(byte[] msg) {
		this(new String(msg));
	}
	
	
	public Message(double msg) {
		this(String.valueOf(msg));
	}
	
	public void setTopic(String topic) {
		this.topic=topic;
	}
	
	public String getTopic() {
		return this.topic;
	}
	
	
	
	public static void main(String[] args) {
		Message msg1= new Message("hello");
		System.out.println("Text: "+msg1.asText);
		
		System.out.println("Double: "+msg1.asDouble);
		
		System.out.println("Date: "+msg1.date);
		

		Message msg2=new Message("234.5");
		
		System.out.println("Double: "+msg2.asDouble);
		
		
		Message msg3=new Message(new byte[] {'H', 'i'});
		
		System.out.println("Text: "+msg3.asText);
		
		
		Message msg4=new Message(45.6);
		
		System.out.println("Double: "+msg4.asDouble);
		System.out.println("Text: "+msg4.asText);
		
		
		

	}
}
