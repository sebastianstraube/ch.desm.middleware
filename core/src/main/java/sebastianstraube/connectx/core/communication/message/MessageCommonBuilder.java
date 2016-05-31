package sebastianstraube.connectx.core.communication.message;

public class MessageCommonBuilder {

    private String globalId = null;
    private String outputInput = "";
    private String externIntern = "";
    private String element = "";
    private String function = "";
    private String instance = "";
    private String topic = null;
    private MessageCommon.ParameterType type = null;
    private String parameter = null;

    public MessageCommon build() throws MissingArgumentsException {
        if (isNullOrEmpty(globalId) || isNullOrEmpty(topic) || isNullOrEmpty(type) || isNullOrEmpty(parameter)) {
            throw new MissingArgumentsException();
        }
        return new MessageCommon(globalId, outputInput, externIntern, element, function, instance, topic, type, parameter);
    }

    public static class MissingArgumentsException extends Exception {
        MissingArgumentsException() {
            super("Not all required arguments provided");
        }
    }

    public String getGlobalId() {
        return globalId;
    }

    public MessageCommonBuilder setGlobalId(String globalId) {
        this.globalId = globalId;
        return this;
    }

    public String getOutputInput() {
        return outputInput;
    }

    public MessageCommonBuilder setOutputInput(String outputInput) {
        this.outputInput = outputInput;
        return this;
    }

    public String getExternIntern() {
        return externIntern;
    }

    public MessageCommonBuilder setExternIntern(String externIntern) {
        this.externIntern = externIntern;
        return this;
    }

    public String getElement() {
        return element;
    }

    public MessageCommonBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    public String getFunction() {
        return function;
    }

    public MessageCommonBuilder setFunction(String function) {
        this.function = function;
        return this;
    }

    public String getInstance() {
        return instance;
    }

    public MessageCommonBuilder setInstance(String instance) {
        this.instance = instance;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public MessageCommonBuilder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public MessageCommon.ParameterType getType() {
        return type;
    }

    public MessageCommonBuilder setType(MessageCommon.ParameterType type) {
        this.type = type;
        return this;
    }

    public String getParameter() {
        return parameter;
    }

    public MessageCommonBuilder setParameter(String parameter) {
        this.parameter = parameter;
        return this;
    }

    private boolean isNullOrEmpty(Object  str) {
        return str == null;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
