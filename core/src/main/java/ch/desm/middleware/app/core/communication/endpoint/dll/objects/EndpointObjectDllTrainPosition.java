package ch.desm.middleware.app.core.communication.endpoint.dll.objects;

import java.util.LinkedList;

public class EndpointObjectDllTrainPosition {
	public int trainTyp;
	public int direction;
	public LinkedList positions;
	public LinkedList gleisList;

	public EndpointObjectDllTrainPosition(int trainTyp, int direction, LinkedList positions,
			LinkedList gleisList) {
		this.trainTyp = trainTyp;
		this.direction = direction;
		this.positions = positions;
		this.gleisList = gleisList;
	}

	@Override
	public String toString() {
		String s = "";
		s += "trainTyp: " + trainTyp;
		s += ", ";
		s += "direction: " + direction;
		s += ", ";
		s += "positions: " + positions;
		s += ", ";
		s += "gleisList: " + gleisList;

		return s;
	}
}
