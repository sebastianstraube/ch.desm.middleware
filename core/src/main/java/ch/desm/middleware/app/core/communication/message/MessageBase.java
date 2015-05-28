package ch.desm.middleware.app.core.communication.message;


public class MessageBase{
	
	public static final String MESSAGE_PARAMETER_DELIMITER = "?";
    public static final String MESSAGE_ELEMENT_CUT = ";";
    public static final String MESSAGE_MESSAGE_CUT = "#";
	public static final String MESSAGE_PARAMETER_ON = "on";
	public static final String MESSAGE_PARAMETER_OFF = "off";
	
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM = "locsim";
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM_DLL = "locsim-dll";
	public static final String MESSAGE_TOPIC_SIMULATION_LOCSIM_RS232 = "locsim-rs232";
	public static final String MESSAGE_TOPIC_CABINE_RE420 = "kabinere420";
	public static final String MESSAGE_TOPIC_INTERLOCKING_OBERMATT = "stellwerkobermattlangnau";
	public static final String MESSAGE_TOPIC_PETRINET_OBERMATT = "petrinet_obermatt";
    public static final String MESSAGE_TOPIC_PETRINET_CABINE_RE420 = "petrinet_cabine_re420";
	public static final String MESSAGE_TOPIC_MANAGEMENT = "management";
    public static final String MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT = "zusi_fahrpult";
    public static final String MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG = "zusi_ausbildung";
	
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
