package ch.desm.middleware.app.core.component.simulation.zusi.logic;

import ch.desm.middleware.app.core.common.utility.UtilityMessageProcessor;
import ch.desm.middleware.app.core.component.simulation.zusi.ZusiService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

//Register = AN, Pin = 0
public class ZusiLogicIsolierungTest extends ZusiLogicIsolierung {

	private static Logger LOGGER = Logger.getLogger(ZusiLogicIsolierungTest.class);
    private ZusiLogicIsolierungTest zusiLogicIsolierungTest;

    @Before
    public void setUp() throws Exception {
        this.zusiLogicIsolierungTest = new ZusiLogicIsolierungTest();
    }

    /**
     *
     * @return
     */
    @Test
	public void getGlobalId(){
        int value = 800;
        boolean b = ZusiLogicIsolierungTest.LOGIC_ISOLIERUNG_BELEGEN_TMP.equalsIgnoreCase(getGlobalId(value));
        LOGGER.log(Level.INFO, "(true) test occupied isolierung zugspitze: " + b);
        Assert.assertEquals(true, b);
	}

    /**
     *
     */
    @Test
    public void getIsoOccZugspitze(){
        int gesamtweg = 800;
        String test = zusiLogicIsolierungTest.getIsoOccZugspitze(gesamtweg);
        boolean b = ZusiLogicIsolierungTest.LOGIC_ISOLIERUNG_BELEGEN_TMP.equalsIgnoreCase(test);
        LOGGER.log(Level.INFO, "(true) test occupied isolierung zugspitze: " + b);
        Assert.assertEquals(true, b);

    }

    /**
     *
     */
    @Test
    public void getIsoOccZugschluss(){
        int gesamtweg = 0;
        String test = zusiLogicIsolierungTest.getIsoOccZugschluss(gesamtweg);
        boolean b = "".equalsIgnoreCase(test);
        LOGGER.log(Level.INFO, "(true) test occupied isolierung zugschluss: " + b);
        Assert.assertEquals(true, b);
    }

    /**
     *
     */
    @Test
    public void getAllIsoOcc(){
        /*
         if(value >= 2929 && value < 3023){globalId = isolierungen[1];} else //OML_Iso_egf_$belegen
         if(value >= 3023 && value < 3092){globalId = isolierungen[2];} else //OML_Iso_1_$belegen
         if(value >= 3092 && value < 3182){globalId = isolierungen[3];} else //OML_Iso_ef_$belegen
        */
        int gesamtweg = 3180;

        String[] listCmp = getAllIsoOcc(gesamtweg);
        String[] listOccIso= {ZusiLogicIsolierungTest.LOGIC_ISOLIERUNG_BELEGEN_TMP, ZusiLogicIsolierungTest.LOGIC_ISOLIERUNG_BELEGEN_EGF, ZusiLogicIsolierung.LOGIC_ISOLIERUNG_BELEGEN_1, ZusiLogicIsolierung.LOGIC_ISOLIERUNG_BELEGEN_EF};
        boolean b = UtilityMessageProcessor.listEquals(listCmp, listOccIso);

        LOGGER.log(Level.INFO, "(true) test all occupied isolierung with gesamtweg: " + gesamtweg + " is: " + b);
        Assert.assertEquals(true, b);
    }

    /**
     *
     */
    @Test
    public void getAllIsoMiddlewareMessage(){
        ZusiService service = new ZusiService();
        int gesamtweg = 3180;

        ArrayList cmp = new ArrayList();
        cmp.add("logic_iso_ce_belegen;;;isolierung;ce;belegen;off;zusi_ausbildung;#");
        cmp.add("");
        cmp.add("logic_iso_egf_belegen;;;isolierung;egf;belegen;on;zusi_ausbildung;#");
        cmp.add("logic_iso_1_belegen;;;isolierung;1;belegen;on;zusi_ausbildung;#");
        cmp.add("logic_iso_ef_belegen;;;isolierung;ef;belegen;on;zusi_ausbildung;#");
        cmp.add("logic_iso_cd_belegen;;;isolierung;cd;belegen;off;zusi_ausbildung;#");
        ArrayList l = getAllIsoMiddlewareMessage(service, gesamtweg);
        boolean b = cmp.equals(l);
        LOGGER.log(Level.INFO, "(true) test occupied isolierung middleware messages: " + b);
        Assert.assertEquals(true, b);
    }
}
