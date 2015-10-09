package ch.desm.middleware.app.module.gui.map;

import ch.desm.middleware.app.core.component.ComponentMapBase;

import java.util.Map;

public class ManagementMapMiddleware extends ComponentMapBase {

	public ManagementMapMiddleware() {
		super();
	}

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	protected void init() {
		map.put("mgmt.stellwerk.obermattlangnau", "mgmt.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;?;management;#");map.put("mgmt.petrinet.obermatlangnau", "mgmt.petrinet.obermatlangnau;os;0;management;petrinet;obermattlangnau;?;management;#");map.put("mgmt.cabine.re420.fabisch", "mgmt.cabine.re420.fabisch;os;0;management;cabine;re420.fabisch;?;management;#");map.put("mgmt.cabine.re420.ubw32", "mgmt.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;?;management;#");map.put("mgmt.simulation.locsim.rs232", "mgmt.simulation.locsim.rs232;os;0;management;simulation;locsim.rs232;?;management;#");map.put("mgmt.simulation.locsim.dll", "mgmt.simulation.locsim.dll;os;0;management;simulation;locsim.dll;?;management;#");

	}

}
