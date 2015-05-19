package ch.desm.middleware.app.core.component.simulation.zusi.logic;

import ch.desm.middleware.app.core.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.communication.message.MessageBase;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.ArrayList;

//Register = AN, Pin = 0
public class ZusiLogicIsolierung {

	private static Logger LOGGER = Logger.getLogger(ZusiLogicIsolierung.class);
    private Object trainPositionLock;

    public static final int TRAIN_LENGTH = 500;
    public static String LOGIC_ISOLIERUNG_BELEGEN_CE = "logic_iso_ce_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_EGF = "logic_iso_egf_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_1 = "logic_iso_1_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_EF = "logic_iso_ef_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_CD = "logic_iso_cd_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_UNKNOWN = "logic_iso_unknown_belegen";
    public static String LOGIC_ISOLIERUNG_BELEGEN_TMP = "logic_iso_tmp_belegen";
    public static String LOGIC_GLOBALID_GESAMTWEG = "0200-0a00::1900";
    public static String[] isolierungen = {LOGIC_ISOLIERUNG_BELEGEN_CE, LOGIC_ISOLIERUNG_BELEGEN_TMP, LOGIC_ISOLIERUNG_BELEGEN_EGF, LOGIC_ISOLIERUNG_BELEGEN_1, LOGIC_ISOLIERUNG_BELEGEN_EF, LOGIC_ISOLIERUNG_BELEGEN_CD};
    public static String[] trainPosition;

    public ZusiLogicIsolierung(){
        trainPositionLock = new Object();
        trainPosition = new String[isolierungen.length];
    }

    /**
     *
     * @param value
     * @return
     */
	public String getGlobalId(int value){
		String globalId = "";

        if(value < 621 || value >= 3465) LOGGER.log(Level.TRACE, this.getClass().getName() + "processing value skipped: " + value); else
		if(value >= 621 && value < 795){globalId = isolierungen[0]; } else //OML_LN_$ce_belegen
        if(value >= 795 && value < 2929){globalId = isolierungen[1]; } else //unbekannte Isolierung
		if(value >= 2929 && value < 3023){globalId = isolierungen[2];} else //OML_Iso_egf_$belegen
        if(value >= 3023 && value < 3092){globalId = isolierungen[3];} else //OML_Iso_1_$belegen
		if(value >= 3092 && value < 3182){globalId = isolierungen[4];} else //OML_Iso_ef_$belegen
		if(value >= 3182 && value < 3465){globalId = isolierungen[5];} //OML_Iso_cd_$belegen


        if(!globalId.isEmpty()) LOGGER.log(Level.TRACE, this.getClass().getName() + "processing value: " + value);

        return globalId;
	}

    protected String getIsoOccZugspitze(int gesamtweg){
        return getGlobalId(gesamtweg);
    }

    protected String getIsoOccZugschluss(int gesamtweg){
        return getGlobalId(gesamtweg - TRAIN_LENGTH);
    }

    public String[] getAllIsoOcc(int gesamtweg){
        synchronized (trainPositionLock){
            String occZugspitze = getIsoOccZugspitze(gesamtweg);
            String occZugschluss = getIsoOccZugschluss(gesamtweg);
            boolean start = false;
            boolean end = false;

            for(int i=0; i<isolierungen.length; i++){
                if((occZugschluss.equalsIgnoreCase(isolierungen[i])) && !start){
                    trainPosition[i] = isolierungen[i];
                    end = true;
                }else if(occZugspitze.equalsIgnoreCase(isolierungen[i])){
                    trainPosition[i] = isolierungen[i];
                    start = true;
                }else if(end && !start){
                    trainPosition[i] = isolierungen[i];
                }else{
                    trainPosition[i] = "";
                }
            }

            return UtilityMessageProcessor.trimList(trainPosition);
        }
    }

    public ArrayList<String> getAllIsoMiddlewareMessage(ZusiService service, int gesamtweg){

        String occGlobalIds[] = getAllIsoOcc(gesamtweg);
        ArrayList mwMessagesList = new ArrayList();

        for(int i=0; i<isolierungen.length;i++){
            String mwMessage = service.getComponentMapMiddleware().getValue(isolierungen[i]);
            if(UtilityMessageProcessor.listContains(occGlobalIds, isolierungen[i])) mwMessage = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwMessage, MessageBase.MESSAGE_PARAMETER_ON);
            else mwMessage = UtilityMessageProcessor.replaceMiddlewareMessageDelimiter(mwMessage, MessageBase.MESSAGE_PARAMETER_OFF);
            mwMessagesList.add(mwMessage);
        }

        return mwMessagesList;
    }

}
