package sebastianstraube.connectx.core.communication.message;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MessageCommon {

	private static Logger LOGGER = Logger.getLogger(MessageCommon.class);

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
	public static final String MESSAGE_TOPIC_AUTOMATION = "ihome_automation";

	public enum ParameterType {
		NULL,
		BOOLEAN,
		INTEGER,
		DOUBLE,
		STRING,
	}

	// input/output types
	public static final String MESSAGE_CHAR_INPUT = "I";
	public static final String MESSAGE_CHAR_ONLYSOFTWARE = "OS";

	/**
	 * positions
	 */
	public static final int ID = 0;
	public static final int OUTPUT_INPUT = 1;
	public static final int EXTERN_INTERN = 2;
	public static final int ELEMENT = 3;
	public static final int FUNCTION = 4;
	public static final int INSTANCE = 5;
	public static final int TOPIC = 6;
	public static final int TYPE = 7;
	public static final int PARAMETER = 8;
	public static final int NUM_PARTS = 9;

	private final String messageId;
	private final String globalId;
	private final String outputInput;
	private final String externIntern;
	private final String element;
	private final String function;
	private final String instance;
	private final String topic;
	private final ParameterType type;
	private final String parameter;

	MessageCommon(String globalId, String outputInput, String externIntern, String element,
                  String function, String instance, String topic, ParameterType type, String parameter) {
		this.messageId = String.valueOf(System.currentTimeMillis());
		this.globalId = globalId;
		this.outputInput = outputInput;
		this.externIntern = externIntern;
		this.element = element;
		this.function = function;
		this.instance = instance;
		this.topic = topic;
		this.type = type;
		this.parameter = parameter;
	}

	public String getGlobalId() {
		return this.globalId;
	}

	public String getOutputInput() {
		return this.outputInput;
	}

	public boolean isInputMessage() {
		return outputInput != null && outputInput.equalsIgnoreCase(MESSAGE_CHAR_INPUT);
	}

	public String getExternIntern() {
		return this.externIntern;
	}

	public String getElement() {
		return this.element;
	}

	public String getFunction() {
		return this.function;
	}

    public String getInstance() {
        return this.instance;
    }

	public String getTopic(){
		return this.topic;
	}

    public ParameterType getType() {
        return this.type;
    }

	public String getTypeName() {
		return type.name();
	}

	public Boolean getParameterAsBoolean() throws BadParameterTypeCastException {
		if (type != ParameterType.BOOLEAN || (!parameter.equalsIgnoreCase(MESSAGE_PARAMETER_ON) && !parameter.equalsIgnoreCase(MESSAGE_PARAMETER_OFF))) {
			throw new BadParameterTypeCastException(ParameterType.BOOLEAN, type);
		}
		return parameter.equalsIgnoreCase(MESSAGE_PARAMETER_ON);
	}

	public String getParameterAsOnOff() throws BadParameterTypeCastException {
		if (type != ParameterType.BOOLEAN) {
			throw new BadParameterTypeCastException(ParameterType.BOOLEAN, type);
		}
		return parameter.equalsIgnoreCase(MESSAGE_PARAMETER_ON) ? MESSAGE_PARAMETER_ON : MESSAGE_PARAMETER_OFF;
	}

	public Integer getParameterAsInteger() throws BadParameterTypeCastException {
		if (type != ParameterType.INTEGER) {
			throw new BadParameterTypeCastException(ParameterType.INTEGER, type);
		}
		return Integer.valueOf(parameter);
	}

	public Double getParameterAsDouble() throws BadParameterTypeCastException {
		if (type != ParameterType.DOUBLE) {
			throw new BadParameterTypeCastException(ParameterType.DOUBLE, type);
		}
		return Double.valueOf(parameter);
	}

	public String getParameterAsString() throws BadParameterTypeCastException {
		if (type != ParameterType.STRING) {
			throw new BadParameterTypeCastException(ParameterType.STRING, type);
		}
		return parameter;
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

	public String toString() {
		String s = "";
		s += "topic: " + topic;
		s += ", ";
		s += "messageId: "+messageId;
		s += ", ";
		s += "globalId: " + globalId;
        s += ", ";
        s += "outputInput: " + outputInput;
		s += ", ";
		s += "externIntern: " + externIntern;
		s += ", ";
		s += "element: " + element;
		s += ", ";
		s += "function: " + function;
        s += ", ";
        s += "instance: " + instance;
        s += ", ";
        s += "type: " + type;
        s += ", ";
        s += "parameter: " + parameter;

		return s;
	}

}
