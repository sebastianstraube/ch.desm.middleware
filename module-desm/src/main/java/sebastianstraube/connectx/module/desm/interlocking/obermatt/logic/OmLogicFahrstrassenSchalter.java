package sebastianstraube.connectx.module.desm.interlocking.obermatt.logic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

//Register = AN, Pin = 0
public class OmLogicFahrstrassenSchalter {

	private static Logger LOGGER = Logger.getLogger(OmLogicFahrstrassenSchalter.class);

	final private List<String> globalIdList = new ArrayList<String>(){{
		add("8.91.07");
		add("8.91.06");
		add("8.91.05");
		add("8.91.04");
		add("8.91.03");
		add("8.91.01");
		add("8.91.19");
		add("8.91.20");
		add("8.91.21");
		add("8.91.22");
		add("8.91.23");
	}};


	public String getEnabledGlobalId(Double percentValue) {
		int value = (int)Math.round(percentValue * 1023);
		int idx = getGlobalIdIdx(value);
		String globalId = "";

		if(idx <0) {
			LOGGER.error("invalid Fahrstrassenschalter map for analog value: " + value + " with globalId: " + globalId);
			return "";
		}

		if(idx >= 0) {
			globalId = globalIdList.get(idx);
			LOGGER.trace("Fahrstrassenschalter map analog value: " + value + " to globalId: " + globalId);
		}
        return globalId;
	}

	public List<String> getDisabledGlobalIdList(String enabledGlobalId){
		ArrayList<String> disabledGlobalIdList = new ArrayList<>(globalIdList);
		disabledGlobalIdList.remove(enabledGlobalId);
		return disabledGlobalIdList;
	}

	private int getGlobalIdIdx(int value){
		int idx = -1;

		if(value >= 270 && value < 330){idx = 0; } else //FSS 90� F
		if(value >= 330 && value < 390){idx = 1;} else //FSS 80� F
		if(value >= 390 && value < 440){idx = 2;} else //FSS 45� F
		if(value >= 440 && value < 460){idx = 3;} else //FSS 30� F
		if(value >= 460 && value < 510){idx = 4;} else //FSS 10� F
		if(value >= 510 && value < 555){idx = 5;} else //FSS Grundstellung OK
		if(value >= 555 && value < 580){idx = 6;} else //FSS 10� EG
		if(value >= 580 && value < 630){idx = 7;} else //FSS 30� EG
		if(value >= 630 && value < 690){idx = 8;} else //FSS 45� EG
		if(value >= 690 && value < 745){idx = 9;} else //FSS 80� EG
		if(value >= 745 && value < 770){idx = 10;} //FSS 90� EG

		if(idx == -1) LOGGER.error("invalid mapping value: " + value);
		return idx;
	}
}
