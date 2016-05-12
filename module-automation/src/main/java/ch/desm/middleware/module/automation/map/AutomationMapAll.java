package ch.desm.middleware.module.automation.map;

import ch.desm.middleware.core.component.ComponentMapBase;

public class AutomationMapAll extends ComponentMapBase {

	@Override
	protected void init(){
		map.putAll(new AutomationMapUbw32Analog().getMap());
		map.putAll(new AutomationMapUbw32Digital().getMap());
	}
}
