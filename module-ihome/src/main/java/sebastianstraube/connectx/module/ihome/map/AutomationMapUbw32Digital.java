package sebastianstraube.connectx.module.ihome.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

public class AutomationMapUbw32Digital extends ComponentMapBase {

	public static final String PINBITMASK_CONFIGURATION_DIGITAL = "0,0,0,0,0,0,0";

	@Override
	protected void init() {

		map.put("module.automation_switchc2", "C2"); //
		map.put("module.automation_switchc3", "C3"); //
	}

}
