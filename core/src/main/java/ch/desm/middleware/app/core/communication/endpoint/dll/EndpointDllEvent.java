package ch.desm.middleware.app.core.communication.endpoint.dll;

import java.util.LinkedList;

public class EndpointDllEvent {
	public int type;
	public LinkedList<Integer> params;

	public EndpointDllEvent(int type, LinkedList<Integer> params) {
		this.type = type;
		this.params = params;
	}
}
