package ch.desm.middleware.module.desm.simulation.etcs.protocol;

/**
 * Created by Sebastian on 09.10.2015.
 */
public class EtcsStateTIU {

    /*
    0 Header[“T”]+
    1 Sleeping[1|0]
    2 Pantograph[1|0]
    3 MainCircuitBrake[1|0]
    4 CabStatus[00”no cab”|01 “cab A active”|10”cab B active”|11“not defined”]
    5 DirectionController [00”Neutral”|01”forward”|10”backward” 11”not defined”] +TrainIntegrity[1|0]
    6 PassengerBrake[1”applied”|0”released”]
    7 DoorControl[00 “opening”|01”open”|10 “closed”|11 ]
    ETCSMainSwitch[1|0]
    Isolation[1|0]
    SystemFailure[1|0]
    ServiceBrake[1|0]
    EmergencyBrake[1|0]
     */


}
