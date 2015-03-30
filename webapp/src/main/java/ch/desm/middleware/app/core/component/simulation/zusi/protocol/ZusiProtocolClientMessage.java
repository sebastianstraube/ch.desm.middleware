package ch.desm.middleware.app.core.component.simulation.zusi.protocol;

import org.apache.log4j.Logger;

/**
 * Created by Sebastian on 27.03.2015.
 */
public class ZusiProtocolClientMessage {

    private static Logger LOGGER = Logger.getLogger(ZusiProtocolClientMessage.class);

    private ZusiProtocolEncoderDecoder encodeDecode;

    public ZusiProtocolClientMessage(){
        this.encodeDecode = new ZusiProtocolEncoderDecoder();
    }

    /**
     *
     * @return
     */
    public String getMessageConnectAusbildung() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode start = new ZusiProtocolNode(1);
        ZusiProtocolNode hello = new ZusiProtocolNode(1);
        ZusiProtocolNode protocolVersion = new ZusiProtocolNode(1, 2, 2);
        ZusiProtocolNode clientType = new ZusiProtocolNode(2, 3, 2);
        ZusiProtocolNode text = new ZusiProtocolNode(3, ZusiProtocolConstants.CLIENT_TYPE + "(Ausbildung)");
        ZusiProtocolNode version = new ZusiProtocolNode(4, ZusiProtocolConstants.CLIENT_VERSION);

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protocolVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);


        return encodeDecode.decode(root);
    }

    /**
     *
     00 03 <Knoten> Ausbilder-Anwendung 03
     00 0D <Knoten> Befehl TRAINPOS
     00 01 String Zugnummer
     00 02 Single x-Position der Zugspitze bezüglich UTM
     00 03 Single y-Position der Zugspitze bezüglich UTM
     00 04 Single z-Position der Zugspitze bezüglich UTM
     00 05 Single Winkellage der Zugspitze bezüglich UTM-Raster in Radiant
     00 06 Single Aktuelle Geschwindigkeit des Zuges in m/s
     00 07 Single Aktuelle Kilometrierung
     00 08 String Grund einer aktuellen Zwangsbremsung
     00 09 Single Datum 00 0A Single Uhrzeit
     00 0B Single x-Position der Zugende bezüglich UTM
     00 0C Single y-Position der Zugende bezüglich UTM
     00 0D Single z-Position der Zugende bezüglich UTM
     00 0E Single Winkellage des Zugendes bezüglich UTM-Raster in Radiant
     *
     * @return
     * @throws Exception
     */
    public String getMessageNeededDataAusbildung() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode client_ausbilder = new ZusiProtocolNode(3);
        ZusiProtocolNode needed_data = new ZusiProtocolNode(3);
        ZusiProtocolNode trainpos = new ZusiProtocolNode(1, 20, 2);
        // trainpos.setData(ZusiProtocolAusbildungssteuerung.COMMAND_FROM_TRAINPOS); //TODO implementation if byte length!

        root.addNode(client_ausbilder);
        client_ausbilder.addNode(needed_data);
        needed_data.addNode(trainpos);

        return encodeDecode.decode(root);
    }

    /**
     *
     * @return
     */
    public String getMessageConnectFahrpult() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode start = new ZusiProtocolNode(1);
        ZusiProtocolNode hello = new ZusiProtocolNode(1);
        ZusiProtocolNode protocolVersion = new ZusiProtocolNode(1, 2, 2);
        ZusiProtocolNode clientType = new ZusiProtocolNode(2, 2, 2);
        ZusiProtocolNode text = new ZusiProtocolNode(3, ZusiProtocolConstants.CLIENT_TYPE + "(Fahrpult)");
        ZusiProtocolNode version = new ZusiProtocolNode(4, ZusiProtocolConstants.CLIENT_VERSION);

        root.addNode(start);
        start.addNode(hello);
        hello.addNode(protocolVersion);
        hello.addNode(clientType);
        hello.addNode(text);
        hello.addNode(version);

        return encodeDecode.decode(root);
    }

    /**
     * Needed Data > Zusi
     * @return
     */
    public String getMessageNeededDataFahrpult() throws Exception{
        ZusiProtocolNodeBase root = new ZusiProtocolNodeBase();
        ZusiProtocolNode client_fahrpult = new ZusiProtocolNode(2);
        ZusiProtocolNode needed_data = new ZusiProtocolNode(3);
        ZusiProtocolNode fuehrerstandsAnzeigen = new ZusiProtocolNode(10);
        ZusiProtocolNode geschwindigkeit = new ZusiProtocolNode(1, 1, 4);

        root.addNode(client_fahrpult);
        client_fahrpult.addNode(needed_data);
        needed_data.addNode(fuehrerstandsAnzeigen);
        fuehrerstandsAnzeigen.addNode(geschwindigkeit);

        return encodeDecode.decode(root);
    }


}
