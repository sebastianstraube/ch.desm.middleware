package sebastianstraube.connectx.module.ihome.map;

import sebastianstraube.connectx.core.component.ComponentMapBase;

public class AutomationMapAll extends ComponentMapBase {

	@Override
	protected void init(){
		map.putAll(new AutomationMapUbw32Analog().getMap());
		map.putAll(new AutomationMapUbw32Digital().getMap());
	}
}
