package ch.desm.middleware.app.core.component.simulation.zusi.logic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//Register = AN, Pin = 0
public class ZusiLogicIsolierung {

	private static Logger LOGGER = Logger.getLogger(ZusiLogicIsolierung.class);

    public static String LOGIC_ISOLIERUNG_BELEGT_CE = "logic_iso_ce_belegt";
    public static String LOGIC_ISOLIERUNG_BELEGT_EGf= "logic_iso_egf_belegt";
    public static String LOGIC_ISOLIERUNG_BELEGT_1 = "logic_iso_1_belegt";
    public static String LOGIC_ISOLIERUNG_BELEGT_EF = "logic_iso_ef_belegt";
    public static String LOGIC_ISOLIERUNG_BELEGT_CD = "logic_iso_cd_belegt";
    public static String LOGIC_ZUSI_GESAMTWEG = "0200-0a00::1900";

	public String getglobalId(int value){
		String globalId = "";

        LOGGER.log(Level.TRACE, this.getClass().getName() + "processing value: " + value);

		if(value >= 621 && value < 795){globalId = LOGIC_ISOLIERUNG_BELEGT_CE; } else //OML_LN_$ce_belegt
		if(value >= 2929 && value < 3023){globalId = LOGIC_ISOLIERUNG_BELEGT_EGf;} else //OML_Iso_egf_$belegt
        if(value >= 3023 && value < 3092){globalId = LOGIC_ISOLIERUNG_BELEGT_1;} else //OML_Iso_1_$belegt
		if(value >= 3092 && value < 3182){globalId = LOGIC_ISOLIERUNG_BELEGT_EF;} else //OML_Iso_ef_$belegt
		if(value >= 3182 && value < 3465){globalId = LOGIC_ISOLIERUNG_BELEGT_CD;}

        return globalId;
	}
}
