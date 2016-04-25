package ch.desm.middleware.app.core.communication.message;


public class MessageCommon extends MessageBase {

	protected String globalId;
	protected String outputInput;
	protected String externIntern;
	protected String element;
	protected String function;
	protected String parameter;
	protected String instance;

	public MessageCommon(String topic, String globalId, String externIntern,
						 String element, String function, String instance, String parameter,
						 String payload, String outputInput) {
		super(payload, topic);
		this.globalId = globalId;
		this.externIntern = externIntern;
		this.element = element;
		this.function = function;
		this.instance = instance;
		this.parameter = parameter;
		this.outputInput = outputInput;
	}

	public String getOutputInput() {
		return this.outputInput;
	}

	public String getGlobalId() {
		return this.globalId;
	}

	public void setGlobalId(String value){
		this.globalId = value;
	}

	public String getExternIntern() {
		return this.externIntern;
	}

	public void setExternIntern(String value){
		this.externIntern = value;
	}

	public String getElement() {
		return this.element;
	}

	public void setElement(String value){
		this.element = value;
	}

	public String getFunction() {
		return this.function;
	}

	public void setFunction(String value){
		this.function = value;
	}

	public String getParameter() {
		return this.parameter;
	}

	public void setParameter(String value){
		this.parameter = value;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getInstance() {
		return this.instance;
	}

	public String toString() {
		String s = super.toString();
		s += ", ";
		s += "globalId: " + globalId;
		s += ", ";
		s += "externIntern: " + externIntern;
		s += ", ";
		s += "element: " + element;
		s += ", ";
		s += "function: " + function;
		s += ", ";
		s += "parameter: " + parameter;
		s += ", ";
		s += "instance: " + instance;
		s += ", ";
		s += "outputInput: " + outputInput;

		return s;
	}
}
