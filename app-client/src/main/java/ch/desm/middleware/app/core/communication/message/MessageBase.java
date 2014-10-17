package ch.desm.middleware.app.core.communication.message;


public abstract class MessageBase{
	
	public final static String PARAMETER_PLACEHOLDER = "\\?";
	
	public static final String MESSAGE_PARAMETER_ON = "on";
	public static final String MESSAGE_PARAMETER_OFF = "off";
	
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM = "locsim";
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL = "locsim-dll";
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232 = "locsim-rs232";
	public static final String MESSAGE_TOPIC_CABINE_RE420 = "kabinere420";
	public static final String MESSAGE_TOPIC_CABINE_RE420_FABISCH = "kabinere420-fabisch";
	public static final String MESSAGE_TOPIC_INTERLOCKING_OBERMATT_LANGNAU = "stellwerkobermattlangnau";
	public static final String MESSAGE_TOPIC_PETRINET_OBERMATT_LANGNAU = "petrinetoml";
	public static final String MESSAGE_TOPIC_MANAGEMENT = "management";
	
	private String topic;
    private String messageId;
	private String payload;
	
    /**
     * 
     */
    private MessageBase() {
    	this.messageId = String.valueOf(System.currentTimeMillis());
    }
        
    public MessageBase(String payload, String topic) {
    	this();
    	this.payload = payload;
    	this.topic = topic;

    }

    @Override
    public String toString(){
    	String s = "";
		s += "topic: " + topic;
		s += ", ";
    	s+= "messageId: "+messageId; 	
    	return s;
    }
    
    public String getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(String value) {
        this.messageId = value;
    }
    
    public String getPayload(){
    	return this.payload;
    }
    
    public void setPayload(String value) {
        this.payload = value;
    }
    
    public String getTopic(){
    	return this.topic;
    }
    
    public void setTopic(String value) {
        this.topic = value;
    }
}
