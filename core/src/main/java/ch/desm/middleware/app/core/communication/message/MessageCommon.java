package ch.desm.middleware.app.core.communication.message;

public class MessageCommon extends MessageBase {

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

	private final String globalId;
	private final String outputInput;
	private final String externIntern;
	private final String element;
	private final String function;
	private final String instance;
	private final ParameterType type;
	private final String parameter;

	public MessageCommon(String payload, String topic, String globalId, String outputInput,
						 String externIntern, String element, String function, String instance,
						 ParameterType type, String parameter) {
		super(payload, topic);
		this.globalId = globalId;
		this.outputInput = outputInput;
		this.externIntern = externIntern;
		this.element = element;
		this.function = function;
		this.instance = instance;
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

    public ParameterType getType() {
        return this.type;
    }

	public String getTypeName() {
		return type.name();
	}

	public Boolean getParameterAsBoolean() throws BadParameterTypeCastException {
		if (type != ParameterType.BOOLEAN) {
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

	public String toString() {
		String s = super.toString();
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

	public static ParameterType parseParameterType(String type) throws InvalidParameterTypeException {
		if (type.length() != 1) {
			throw new InvalidParameterTypeException();
		}

		switch (type.toLowerCase().charAt(0)) {
			case 'n':
				return ParameterType.NULL;
			case 'b':
				return ParameterType.BOOLEAN;
			case 'i':
				return ParameterType.INTEGER;
			case 'd':
				return ParameterType.DOUBLE;
			case 's':
				return ParameterType.STRING;
			default:
				throw new InvalidParameterTypeException();
		}
	}

	public static class InvalidParameterTypeException extends Exception {}

	public static class BadParameterTypeCastException extends Exception {
		public BadParameterTypeCastException(ParameterType requested, ParameterType actual) {
			super("Unable to cast message parameter type from " + requested.name() + " to " + actual.name());
		}
	}
}
