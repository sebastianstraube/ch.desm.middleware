package ch.desm.middleware.app.core.communication.message;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MessageBase{
    private static Logger LOGGER = Logger.getLogger(MessageBase.class);

    public static final String MESSAGE_PARAMETER_PLACEHOLDER = "?";
    public static final String MESSAGE_ELEMENT_DELIMITER = ";";
    public static final String MESSAGE_MESSAGE_DELIMITER = "#";
	public static final String MESSAGE_PARAMETER_ON = "on";
	public static final String MESSAGE_PARAMETER_OFF = "off";

	public static final String MESSAGE_TOPIC_CABINE_RE420 = "kabinere420";
	public static final String MESSAGE_TOPIC_INTERLOCKING_OBERMATT = "stellwerkobermattlangnau";
	public static final String MESSAGE_TOPIC_PETRINET_OBERMATT = "petrinet_obermatt";
    public static final String MESSAGE_TOPIC_PETRINET_CABINE_RE420 = "petrinet_cabine_re420";
	public static final String MESSAGE_TOPIC_MANAGEMENT = "management";
    public static final String MESSAGE_TOPIC_SIMULATION_ZUSI_FAHRPULT = "zusi_fahrpult";
    public static final String MESSAGE_TOPIC_SIMULATION_ZUSI_AUSBILDUNG = "zusi_ausbildung";
    public static final String MESSAGE_TOPIC_ETCS_TIU = "etcstiu";

	private String topic;
    private String messageId;

    /**
     * 
     */
    private MessageBase() {
    	this.messageId = String.valueOf(System.currentTimeMillis());
    }
        
    public MessageBase(String topic) {
    	this();
    	this.topic = topic;

    }

    public static String replaceMiddlewareMessageDelimiter(String middlewareMessage, String parameterValue){
        return middlewareMessage.replace(MESSAGE_PARAMETER_PLACEHOLDER, parameterValue);
    }

    public static String mapBoolToOnOffParameter(Boolean v) {
        return v ? MESSAGE_PARAMETER_ON : MESSAGE_PARAMETER_OFF;
    }

    public static String mapOnOffParameterTo10String(String value) {
        return String.valueOf(mapOnOffParameterTo10(value));
    }

    public static Integer mapOnOffParameterTo10(String value) {
        return mapOnOffParameterToBool(value) ? 1 : 0;
    }

    public static Boolean mapOnOffParameterToBool(String value) {
        switch (value.toLowerCase()) {
            case MESSAGE_PARAMETER_ON:
                return true;
            case MESSAGE_PARAMETER_OFF:
                return false;
            default:
                LOGGER.log(Level.ERROR, "unexpected (0,1) parameter value: " + value);
                return false;
        }
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
    
    public String getTopic(){
    	return this.topic;
    }
    
    public void setTopic(String value) {
        this.topic = value;
    }
}
