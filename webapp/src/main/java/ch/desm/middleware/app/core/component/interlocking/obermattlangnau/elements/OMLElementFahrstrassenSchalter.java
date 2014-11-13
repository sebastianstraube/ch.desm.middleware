package ch.desm.middleware.app.core.component.interlocking.obermattlangnau.elements;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//Register = AN, Pin = 0
public class OMLElementFahrstrassenSchalter {

	private static Logger LOGGER = Logger.getLogger(OMLElementFahrstrassenSchalter.class);
	
	public String getglobalId(int value){
		String globalId = "";

        LOGGER.log(Level.TRACE, "OMLElementFahrstrassenSchalter processing value: " + value);

		if(value > 270 && value < 290){globalId = "8.91.07"; } else //FSS 90� F
		if(value > 330 && value < 350){globalId = "8.91.06";} else //FSS 80� F
		if(value > 390 && value < 405){globalId = "8.91.05";} else //FSS 45� F
		if(value > 440 && value < 460){globalId = "8.91.04";} else //FSS 30� F
		if(value > 460 && value < 480){globalId = "8.91.03";} else //FSS 10� F
		if(value > 510 && value < 530){globalId = "8.91.01";} else //FSS Grundstellung OK
		if(value > 555 && value < 580){globalId = "8.91.19";} else //FSS 10� EG
		if(value > 580 && value < 600){globalId = "8.91.20";} else //FSS 30� EG
		if(value > 630 && value < 650){globalId = "8.91.21";} else //FSS 45� EG
		if(value > 690 && value < 710){globalId = "8.91.22";} else //FSS 80� EG
		if(value > 745 && value < 770){globalId = "8.91.23";} else //FSS 90� EG
		{
//			try {
//				throw new Exception("no mapping defined for analog register: AN0, value: " + value);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				LOGGER.log(Level.ERROR, e);
//			}
			
		}
        return globalId;
	}
}
