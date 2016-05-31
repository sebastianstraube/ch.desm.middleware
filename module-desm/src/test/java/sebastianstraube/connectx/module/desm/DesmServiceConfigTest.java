package sebastianstraube.connectx.module.desm;

import com.google.gson.Gson;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class DesmServiceConfigTest {

    private static Logger LOGGER = Logger.getLogger(sebastianstraube.connectx.module.desm.simulation.zusi.ZusiMessageProcessorTest.class);

    DesmServiceConfig config;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public static DesmServiceConfig readConfigFile(){
        DesmServiceConfig config = null;

        try {
            FileReader f = new FileReader("/Users/heisenberg/Box Sync/connectx/code/sebastianstraube/connectx/module-desm/config_desm.json");

            config = new Gson().fromJson(f, DesmServiceConfig.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return config;
    }

    @Test
    public void testJsonRead() throws Exception{

     //   LOGGER.log(Level.INFO, "(true) test encode get node stream: " + b);
     //   Assert.assertEquals(true, b);
    }

}
