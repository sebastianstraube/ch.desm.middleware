package ch.desm.middleware.app.module.simulation.zusi.logic;

import ch.desm.middleware.app.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.module.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class ZusiLogicIsolierung {

    public static final int TRAIN_LENGTH = 80; //in m
    public static String LOGIC_ISOLIERUNG_BELEGEN_CE = "logic_iso_ce_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_EGF = "logic_iso_egf_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_1 = "logic_iso_1_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_EF = "logic_iso_ef_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_CD = "logic_iso_cd_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_UNKNOWN = "logic_iso_unknown_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_TMP = "logic_iso_tmp_belegen";
    public static String LOGIC_GLOBALID_GESAMTWEG = "0200-0a00::1900";
    public static String[] ISOLIERUNGEN = {LOGIC_ISOLIERUNG_BELEGEN_CE, LOGIC_ISOLIERUNG_BELEGEN_TMP, LOGIC_ISOLIERUNG_BELEGEN_EGF, LOGIC_ISOLIERUNG_BELEGEN_1, LOGIC_ISOLIERUNG_BELEGEN_EF, LOGIC_ISOLIERUNG_BELEGEN_CD};

    private static Logger LOGGER = Logger.getLogger(ZusiLogicIsolierung.class);
    private Object trainPositionLock;
    private static String[] TRAIN_POSITION = new String[ISOLIERUNGEN.length];

    public ZusiLogicIsolierung(){
        this.trainPositionLock = new Object();
    }

    /**
     *
     * @param value
     * @return
     */
	public String getGlobalId(int value){
		String globalId = "";

        if(value < 621 || value >= 3465) LOGGER.log(Level.TRACE, this.getClass().getName() + "processing value skipped: " + value); else
		if(value >= 621 && value < 795){globalId = ISOLIERUNGEN[0]; } else //OML_LN_$ce_belegen
        if(value >= 795 && value < 2929){globalId = ISOLIERUNGEN[1]; } else //unbekannte Isolierung
		if(value >= 2929 && value < 3023){globalId = ISOLIERUNGEN[2];} else //OML_Iso_egf_$belegen
        if(value >= 3023 && value < 3092){globalId = ISOLIERUNGEN[3];} else //OML_Iso_1_$belegen
		if(value >= 3092 && value < 3182){globalId = ISOLIERUNGEN[4];} else //OML_Iso_ef_$belegen
		if(value >= 3182 && value < 3465){globalId = ISOLIERUNGEN[5];} //OML_Iso_cd_$belegen

        if(!globalId.isEmpty()) LOGGER.log(Level.TRACE, this.getClass().getName() + "processing value: " + value);

        return globalId;
	}

    protected String getIsoOccZugspitze(int gesamtweg){
        return getGlobalId(gesamtweg);
    }

    protected String getIsoOccZugschluss(int gesamtweg){
        return getGlobalId(gesamtweg - TRAIN_LENGTH);
    }

    protected ArrayList<String> getAllIsoOcc(int gesamtweg){
        synchronized (trainPositionLock){
            String occZugspitze = getIsoOccZugspitze(gesamtweg);
            String occZugschluss = getIsoOccZugschluss(gesamtweg);
            boolean start = false;
            boolean end = false;

            if(occZugspitze.equalsIgnoreCase(occZugschluss)){
                TRAIN_POSITION[0] = occZugspitze;
            }else{
                for(int i=0; i< ISOLIERUNGEN.length; i++){
                    if((occZugschluss.equalsIgnoreCase(ISOLIERUNGEN[i])) && !start){
                        TRAIN_POSITION[i] = ISOLIERUNGEN[i];
                        end = true;
                    }else if(occZugspitze.equalsIgnoreCase(ISOLIERUNGEN[i])){
                        TRAIN_POSITION[i] = ISOLIERUNGEN[i];
                        start = true;
                    }else if(end && !start){
                        TRAIN_POSITION[i] = ISOLIERUNGEN[i];
                    }else{
                        TRAIN_POSITION[i] = "";
                    }
                }
            }

            return new ArrayList<String>(Arrays.asList(UtilityMessageProcessor.trimList(TRAIN_POSITION)));
        }
    }

    public ArrayList getAllIsoMwm(ZusiService service, int gesamtweg){

        ArrayList messages = new ArrayList();
        ArrayList occ = getAllIsoOcc(gesamtweg);

        for(int i=0; i< ISOLIERUNGEN.length; i++){
            String mwMessage = service.getComponentMapMiddleware().getValue(ISOLIERUNGEN[i]);
            if(occ.contains(ISOLIERUNGEN[i])) mwMessage = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwMessage, MessageBase.MESSAGE_PARAMETER_ON);
            else mwMessage = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwMessage, MessageBase.MESSAGE_PARAMETER_OFF);
            if(!mwMessage.isEmpty()) messages.add(mwMessage);
        }

        return messages;
    }
}
