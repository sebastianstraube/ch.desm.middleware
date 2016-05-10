package ch.desm.middleware.module.management.map;

import ch.desm.middleware.core.component.ComponentMapBase;

public class ManagementMapMiddleware extends ComponentMapBase {

	public ManagementMapMiddleware() {
		super();
	}

	@Override
	protected void init() {
		map.put("management.stellwerk.obermattlangnau", "management.stellwerk.obermattlangnau;os;0;management;stellwerk;obermattlangnau;management;s;?;");
		map.put("management.petrinet.obermattlangnau", "management.petrinet.obermattlangnau;os;0;management;petrinet;obermattlangnau;management;s;?;");
		map.put("management.petrinet.re420", "management.petrinet.re420;os;0;management;petrinet;cabinere420;management;s;?;");
		map.put("management.cabine.re420.ubw32", "management.cabine.re420.ubw32;os;0;management;cabine;re420.ubw32;management;s;?;");
	}

}
