package ch.desm.middleware.module.automation.map;

import ch.desm.middleware.core.component.ComponentMapBase;

public class AutomationMapMiddleware extends ComponentMapBase {

	@Override
	protected void init(){
		map.put("module.automation_switchc2", "module.automation_switchc2;os;0;module;automation;switch_c2;automation;b;?;"); //
		map.put("module.automation_switchc3", "module.automation_switchc3;os;0;module;automation;switch_c3;automation;b;?;"); //

	}
}
