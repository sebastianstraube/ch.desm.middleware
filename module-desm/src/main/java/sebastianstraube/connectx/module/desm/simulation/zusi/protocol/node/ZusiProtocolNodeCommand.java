package sebastianstraube.connectx.module.desm.simulation.zusi.protocol.node;

import sebastianstraube.connectx.core.common.UtilityHex;

/**
 * Created by Sebastian on 20.04.2015.
 */
public class ZusiProtocolNodeCommand {

    /*
    12.3.4.23. Befehl 01 12 – SIGNALDIRECT (Client  Zusi) → Der SIGNALDIRECT-Befehl
    überträgt das Kommando zum Stellen eines Signals über die direkte Auswahl des Signalbegriffs vom Client an Zusi.
    00 03 <Knoten> Ausbilder-Anwendung 03
        01 12 <Knoten> Befehl SIGNALDIRECT
            00 01 String Streckenmodul des Signals relativ zum Zusi-Verzeichnis
            00 02 Cardinal Referenz-Nummer des Signals im gewählten Streckenmodul
            00 03 64bit-integer Signalbegriff binär codiert
            00 04 Single Zulässige Geschwindigkeit am Signal in m/s
            00 05 <Knoten> Ereignis
                00 01 Cardinal Ereigniswert
            00 05 <Knoten> Beliebig viele weitere Ereignisse
    */
    public ZusiProtocolNode getSignalDirect(String streckenModul, int referenzNrSignal, int signalBegriff, int zulGeschwSignal, int ereignisWert){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeAusbilderAnwendung = new ZusiProtocolNode(nodeRoot, "0300", "");
        ZusiProtocolNode nodeBefehlSignalDirect = new ZusiProtocolNode(nodeAusbilderAnwendung, "1201", "");
        ZusiProtocolNode nodeStreckenmodul = new ZusiProtocolNode(nodeBefehlSignalDirect, "0100", UtilityHex.toHex(streckenModul));
        ZusiProtocolNode nodeReferenzSignal = new ZusiProtocolNode(nodeStreckenmodul, "0200", UtilityHex.toHex(referenzNrSignal));
        ZusiProtocolNode nodeSignalBegriff = new ZusiProtocolNode(nodeReferenzSignal, "0300", UtilityHex.toHex(signalBegriff));
        ZusiProtocolNode nodezulGeschwSignal = new ZusiProtocolNode(nodeSignalBegriff, "0400", UtilityHex.toHex(zulGeschwSignal));
        ZusiProtocolNode nodeEreignis = new ZusiProtocolNode(nodezulGeschwSignal, "0500", "");
        ZusiProtocolNode nodeEreignisWert = new ZusiProtocolNode(nodeEreignis, "0100", UtilityHex.toHex(ereignisWert));

        nodeRoot.addNode(nodeAusbilderAnwendung);
        nodeAusbilderAnwendung.addNode(nodeBefehlSignalDirect);
        nodeBefehlSignalDirect.addNode(nodeStreckenmodul);
        nodeBefehlSignalDirect.addNode(nodeReferenzSignal);
        nodeBefehlSignalDirect.addNode(nodeSignalBegriff);
        nodeBefehlSignalDirect.addNode(nodezulGeschwSignal);
        nodeBefehlSignalDirect.addNode(nodeEreignis);
        nodeEreignis.addNode(nodeEreignisWert);
        //previous node needed for traversing
        nodeEreignisWert.setPrevNode(nodeEreignis);

        return nodeRoot;
    }

    /**
     * 12.3.4.18. Befehl 01 0D – SIGNALASPECT (Client  Zusi) → Der SIGNALASPECT-Befehl überträgt das Kommando zum Stellen eines
     * Signalsbegriffs anhand der Signalmatrix vom Client an Zusi.
     * 00 03 <Knoten> Ausbilder-Anwendung 03
     * 01 0D <Knoten> Befehl  SIGNALASPECT
     * 00 01 String Streckenmodul des Signals relativ zum Zusi-Verzeichnis
     * 00 02 Cardinal Referenz-Nummer des Signals im gewählten Streckenmodul
     * 00 03 ShortInt Signalmodus: 0: Normaler Signalbegriff 1: Ersatzsignal -1: Bahnübergang auf defekt setzen
     * 00 04 Word Spalte der Signalmatrix (-1: Grundstellung)
     * 00 05 Word Zeile der Signalmatrix (-1: Grundstellung)
     *
     * @param streckenModul
     * @param referenzNr
     * @param signalModus
     * @param signalMatrixSpalte
     * @param signalMatrixZeile
     * @return
     */
    public ZusiProtocolNode getSignalAspect(String streckenModul, int referenzNr, int signalModus, int signalMatrixZeile, int signalMatrixSpalte){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeAusbilderAnwendung = new ZusiProtocolNode(nodeRoot, "0300", "");
        ZusiProtocolNode nodeBefehl = new ZusiProtocolNode(nodeAusbilderAnwendung, "0D01", "");
        ZusiProtocolNode nodeStreckenmodul = new ZusiProtocolNode(nodeBefehl, "0100", UtilityHex.toHex(streckenModul));
        ZusiProtocolNode nodeReferenzSignal = new ZusiProtocolNode(nodeStreckenmodul, "0200", UtilityHex.toHex(referenzNr));
        ZusiProtocolNode nodeSignalModus = new ZusiProtocolNode(nodeReferenzSignal, "0300", UtilityHex.toHex(signalModus));
        ZusiProtocolNode nodeSignalMatrixSpalte = new ZusiProtocolNode(nodeSignalModus, "0400", UtilityHex.toHex(signalMatrixSpalte));
        ZusiProtocolNode nodeSignalMatrixZeile = new ZusiProtocolNode(nodeSignalMatrixSpalte, "0500", UtilityHex.toHex(signalMatrixZeile));

        nodeRoot.addNode(nodeAusbilderAnwendung);
        nodeAusbilderAnwendung.addNode(nodeBefehl);
        nodeBefehl.addNode(nodeStreckenmodul);
        nodeBefehl.addNode(nodeReferenzSignal);
        nodeBefehl.addNode(nodeSignalModus);
        nodeBefehl.addNode(nodeSignalMatrixSpalte);
        nodeBefehl.addNode(nodeSignalMatrixZeile);

        return nodeRoot;
    }


    /**
     * 12.3.4.17. Befehl 01 0C – SWITCH (Client  Zusi) → Der SWITCH-Befehl überträgt das Kommando zum Stellen einer Weiche vom Client an Zusi.
     * 00 03 <Knoten> Ausbilder-Anwendung 03
     * 01 0C <Knoten> Befehl SWITCH
     * 00 01 String Streckenmodul der Weiche relativ zum Zusi-Verzeichnis
     * 00 02 Cardinal Referenz-Nummer der Weiche im gewählten Streckenmodul
     * 00 03 ShortInt Position der Weiche: 1: Vorrangstrang 2: Abzweig
     *
     * @param streckenModul
     * @param referenzNr
     * @param position
     * @return
     */
    public ZusiProtocolNode getSwitch(String streckenModul, int referenzNr, int position){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeAusbilderAnwendung = new ZusiProtocolNode(nodeRoot, "0300", "");
        ZusiProtocolNode nodeBefehl = new ZusiProtocolNode(nodeAusbilderAnwendung, "0C01", "");
        ZusiProtocolNode nodeStreckenmodul = new ZusiProtocolNode(nodeBefehl, "0100", UtilityHex.toHex(streckenModul));
        ZusiProtocolNode nodeReferenzNummer = new ZusiProtocolNode(nodeStreckenmodul, "0200", UtilityHex.toHex(referenzNr));
        ZusiProtocolNode nodePosition = new ZusiProtocolNode(nodeReferenzNummer, "0300", UtilityHex.toHex(position));

        nodeRoot.addNode(nodeAusbilderAnwendung);
        nodeAusbilderAnwendung.addNode(nodeBefehl);
        nodeBefehl.addNode(nodeStreckenmodul);
        nodeBefehl.addNode(nodeReferenzNummer);
        nodeBefehl.addNode(nodePosition);

        return nodeRoot;
    }

    /**
     *
     */
    public ZusiProtocolNode getRegisterClient(String description, String version, int clientType){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeStart = new ZusiProtocolNode(nodeRoot, "0100", "");
        ZusiProtocolNode nodeHello = new ZusiProtocolNode(nodeStart, "0100", "");
        ZusiProtocolNode nodeProtocolVersion = new ZusiProtocolNode(nodeHello, "0100", "0200");
        ZusiProtocolNode nodeClientType = new ZusiProtocolNode(nodeProtocolVersion, "0200", UtilityHex.toHex(clientType, 4));
        ZusiProtocolNode nodeClientDescription = new ZusiProtocolNode(nodeClientType, "0300", UtilityHex.toHex(description));
        ZusiProtocolNode nodeClientVersion = new ZusiProtocolNode(nodeClientDescription, "0400", UtilityHex.toHex(version));

        nodeRoot.addNode(nodeStart);
        nodeStart.addNode(nodeHello);
        nodeHello.addNode(nodeProtocolVersion);
        nodeHello.addNode(nodeClientType);
        nodeHello.addNode(nodeClientDescription);
        nodeHello.addNode(nodeClientVersion);

        return nodeRoot;
    }

    /**
     *
     */
    public ZusiProtocolNode getAusbildungNeededData(){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeClientAusbilder = new ZusiProtocolNode(nodeRoot, "0300", "");
        ZusiProtocolNode nodeNeededData = new ZusiProtocolNode(nodeClientAusbilder, "0300", "");

        /*
        12.3.4.6. Befehl 00 0D – TRAINPOS (Zusi  Client) → Der TRAINPOS-Befehl überträgt die aktuelle Zugpositionen von Zusi an den Client.
         */
        //ZusiProtocolNode trainpos = new ZusiProtocolNode("0100", "1400");

        /*
        12.3.4.8. Befehl 00 0F – SWITCHPOS (Zusi  Client) → Der SWITCHPOS-Befehl überträgt eine geänderte Weichenstellung von Zusi an den Client.
         */
        //ZusiProtocolNode switchpos = new ZusiProtocolNode("0100", "0F00");


        nodeRoot.addNode(nodeClientAusbilder);
        nodeClientAusbilder.addNode(nodeNeededData);
        //nodeNeededData.addNode(trainpos);

        return nodeRoot;
    }

    /**
     *
     */
    public ZusiProtocolNode getFahrpultNeededData(){
        ZusiProtocolNode nodeRoot = new ZusiProtocolNode();
        ZusiProtocolNode nodeClientFahrpult = new ZusiProtocolNode(nodeRoot, "0200", "");
        ZusiProtocolNode nodeNeededData = new ZusiProtocolNode(nodeClientFahrpult, "0300", "");
        ZusiProtocolNode nodeFuehrerstandsAnzeigen = new ZusiProtocolNode(nodeNeededData, "0A00", "");
        ZusiProtocolNode nodeGeschwindigkeit = new ZusiProtocolNode(nodeFuehrerstandsAnzeigen, "0100", "0100");
        ZusiProtocolNode nodeStromabnehmer = new ZusiProtocolNode(nodeGeschwindigkeit, "0100", "5500");
        ZusiProtocolNode nodeGesamtWeg= new ZusiProtocolNode(nodeStromabnehmer, "0100", "1900");
        ZusiProtocolNode nodeHauptschalter= new ZusiProtocolNode(nodeGesamtWeg, "0100", "1300");

        nodeRoot.addNode(nodeClientFahrpult);
        nodeClientFahrpult.addNode(nodeNeededData);
        nodeNeededData.addNode(nodeFuehrerstandsAnzeigen);
        nodeFuehrerstandsAnzeigen.addNode(nodeGeschwindigkeit);
        nodeFuehrerstandsAnzeigen.addNode(nodeStromabnehmer);
        nodeFuehrerstandsAnzeigen.addNode(nodeGesamtWeg);
        nodeFuehrerstandsAnzeigen.addNode(nodeHauptschalter);

        return nodeRoot;
    }
}
