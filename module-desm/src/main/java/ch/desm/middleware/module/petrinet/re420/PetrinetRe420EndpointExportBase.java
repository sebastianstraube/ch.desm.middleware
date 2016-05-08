package ch.desm.middleware.module.petrinet.re420;

abstract class PetrinetRe420EndpointExportBase{
    public int cabine_re420_fahrschalter_controller_$neutral;
    public int cabine_re420_fahrschalter_controller_$set_fahren_plusplus;
    public int cabine_re420_fahrschalter_controller_$set_bremsen_minus;
    public int cabine_re420_fahrschalter_controller_$set_bremsen_punkt;
    public int cabine_re420_fahrschalter_controller_$s150b;
    public int cabine_re420_fahrschalter_controller_$neutral_aus;
    public int cabine_re420_fahrschalter_controller_$set_fahren_plus;
    public int cabine_re420_fahrschalter_controller_$set_neutral;
    public int cabine_re420_fahrschalter_controller_$fahren_punkt_aus;
    public int cabine_re420_fahrschalter_controller_$fahren_minus;
    public int cabine_re420_fahrschalter_controller_$fahren_minus_aus;
    public int cabine_re420_fahrschalter_controller_$fahren_plus;
    public int cabine_re420_fahrschalter_controller_$fahren_punkt;
    public int cabine_re420_fahrschalter_controller_$fahren_m;
    public int cabine_re420_fahrschalter_controller_$fahren_m_aus;
    public int cabine_re420_fahrschalter_controller_$fahren_plus_aus;
    public int cabine_re420_fahrschalter_controller_$fahren_plusplus;
    public int cabine_re420_fahrschalter_controller_$fahren_plusplus_aus;
    public int cabine_re420_fahrschalter_controller_$bremsen_minus_aus;
    public int cabine_re420_fahrschalter_test_end;
    public int cabine_re420_fahrschalter_controller_$bremsen_minus;
    public int cabine_re420_fahrschalter_controller_$bremsen_punkt_aus;
    public int cabine_re420_fahrschalter_controller_$bremsen_punkt;
    public int cabine_re420_fahrschalter_controller_$bremsen_plus;
    public int cabine_re420_fahrschalter_controller_$bremsen_plus_aus;
    public int cabine_re420_fahrschalter_test_enabled;
    public int cabine_re420_fahrschalter_test_fahren_minus;
    public int cabine_re420_fahrschalter_test_fahren_minus_P1;
    public int cabine_re420_fahrschalter_test_neutral;
    public int cabine_re420_fahrschalter_test_fahren_punkt;
    public int cabine_re420_fahrschalter_test_fahren_minus_P5;
    public int cabine_re420_fahrschalter_test_fahren_minus_P4;
    public int cabine_re420_fahrschalter_test_fahren_minus_P6;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P5;
    public int cabine_re420_fahrschalter_test_fahren_minus_P2;
    public int cabine_re420_fahrschalter_test_fahren_minus_P3;
    public int cabine_re420_fahrschalter_test_fahren_minus_P7;
    public int cabine_re420_fahrschalter_test_fahren_minus_end;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P1;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P6;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P4;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P2;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P7;
    public int cabine_re420_fahrschalter_test_fahren_punkt_P3;
    public int cabine_re420_fahrschalter_test_fahren_punkt_end;
    public int cabine_re420_wendeschalter_$wendeschalter_V;
    public int cabine_re420_wendeschalter_$wendeschalter_0;
    public int cabine_re420_wendeschalter_$wendeschalter_R;
    public int cabine_re420_hauptschalter_$hauptschalter_ein;
    public int cabine_re420_wendeschalter_controller_$140a;
    public int cabine_re420_wendeschalter_controller_$140b;
    public int cabine_re420_stromabnehmer_$stromabnehmer_tief;
    public int cabine_re420_hauptschalter_$hauptschalter_aus;
    public int cabine_re420_hauptschalter_controller_$S132;
    public int cabine_re420_stromabnehmer_$stromabnehmer_hoch;
    public int cabine_re420_stromabnehmer_controller_$S129;
    public int cabine_re420_kompressor_$kompressor_0;
    public int cabine_re420_kompressor_$kompressor_d;
    public int cabine_re420_kompressor_controller_$XXXXX;
    public int cabine_re420_kompressor_$kompressor_A;
    public int cabine_re420_kompressor_controller_$XXXX;
    public int cabine_re420_zugsammelschiene_$zusammelschiene_ein;
    public int cabine_re420_zugsammelschiene_$zusammelschiene_aus;
    public int cabine_re420_totmannpedal_$off;
    public int cabine_re420_zugsammelschiene_controller_$S169;
    public int cabine_re420_totmannpedal_$on;
    public int cabine_re420_totmannpedal_controller_$S235;
    public int cabine_re420_fahrschalter_controller_$set_bremsen_plus;
    public int cabine_re420_fahrschalter_controller_$set_fahren_m;
    public int cabine_re420_fahrschalter_controller_$s150g;
    public int cabine_re420_fahrschalter_controller_$s150l;
    public int cabine_re420_fahrschalter_controller_$s150d;
    public int cabine_re420_fahrschalter_controller_$s150a;
    public int cabine_re420_fahrschalter_controller_$set_fahren_minus;
    public int cabine_re420_fahrschalter_controller_$set_fahren_punkt;
    public int cabine_re420_fahrschalter_controller_$s150e;
    public int cabine_re420_fahrschalter_controller_$s150f;

    //unused places

    public void main() {
        init();
        for(;;) {
            readSensors();
            calcBooleanPlaces();
            while(fireOneTransition()) {
                writeActors();
                calcBooleanPlaces();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean canFire(String s) {
        return true;
    }

    public void fire(String s) {
        System.out.println(s);
    }

    public void readSensors() {
        //cabine_re420_fahrschalter_test_enabled = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P1 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P5 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P4 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P6 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P5 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P2 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P3 = ?
        //cabine_re420_fahrschalter_test_fahren_minus_P7 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P1 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P6 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P4 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P2 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P7 = ?
        //cabine_re420_fahrschalter_test_fahren_punkt_P3 = ?
        //cabine_re420_wendeschalter_controller_$140a = ?
        //cabine_re420_wendeschalter_controller_$140b = ?
        //cabine_re420_hauptschalter_controller_$S132 = ?
        //cabine_re420_stromabnehmer_controller_$S129 = ?
        //cabine_re420_kompressor_controller_$XXXXX = ?
        //cabine_re420_kompressor_controller_$XXXX = ?
        //cabine_re420_zugsammelschiene_controller_$S169 = ?
        //cabine_re420_totmannpedal_controller_$S235 = ?
    }
    public void writeActors() {
        //myData.cabine_re420_fahrschalter_test_end = cabine_re420_fahrschalter_test_end;
        cabine_re420_fahrschalter_test_end = 0;
    }
    public void init() {
        cabine_re420_fahrschalter_controller_$neutral = 0;
        cabine_re420_fahrschalter_controller_$set_fahren_plusplus = 0;
        cabine_re420_fahrschalter_controller_$set_bremsen_minus = 0;
        cabine_re420_fahrschalter_controller_$set_bremsen_punkt = 0;
        cabine_re420_fahrschalter_controller_$s150b = 0;
        cabine_re420_fahrschalter_controller_$neutral_aus = 1;
        cabine_re420_fahrschalter_controller_$set_fahren_plus = 0;
        cabine_re420_fahrschalter_controller_$set_neutral = 0;
        cabine_re420_fahrschalter_controller_$fahren_punkt_aus = 1;
        cabine_re420_fahrschalter_controller_$fahren_minus = 0;
        cabine_re420_fahrschalter_controller_$fahren_minus_aus = 1;
        cabine_re420_fahrschalter_controller_$fahren_plus = 0;
        cabine_re420_fahrschalter_controller_$fahren_punkt = 0;
        cabine_re420_fahrschalter_controller_$fahren_m = 0;
        cabine_re420_fahrschalter_controller_$fahren_m_aus = 1;
        cabine_re420_fahrschalter_controller_$fahren_plus_aus = 1;
        cabine_re420_fahrschalter_controller_$fahren_plusplus = 0;
        cabine_re420_fahrschalter_controller_$fahren_plusplus_aus = 1;
        cabine_re420_fahrschalter_controller_$bremsen_minus_aus = 1;
        cabine_re420_fahrschalter_test_end = 0;
        cabine_re420_fahrschalter_controller_$bremsen_minus = 0;
        cabine_re420_fahrschalter_controller_$bremsen_punkt_aus = 1;
        cabine_re420_fahrschalter_controller_$bremsen_punkt = 0;
        cabine_re420_fahrschalter_controller_$bremsen_plus = 0;
        cabine_re420_fahrschalter_controller_$bremsen_plus_aus = 1;
        cabine_re420_fahrschalter_test_enabled = 0;
        cabine_re420_fahrschalter_test_fahren_minus = 0;
        cabine_re420_fahrschalter_test_fahren_minus_P1 = 0;
        cabine_re420_fahrschalter_test_neutral = 0;
        cabine_re420_fahrschalter_test_fahren_punkt = 0;
        cabine_re420_fahrschalter_test_fahren_minus_P5 = 1;
        cabine_re420_fahrschalter_test_fahren_minus_P4 = 0;
        cabine_re420_fahrschalter_test_fahren_minus_P6 = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_P5 = 0;
        cabine_re420_fahrschalter_test_fahren_minus_P2 = 1;
        cabine_re420_fahrschalter_test_fahren_minus_P3 = 0;
        cabine_re420_fahrschalter_test_fahren_minus_P7 = 0;
        cabine_re420_fahrschalter_test_fahren_minus_end = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_P1 = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_P6 = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_P4 = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_P2 = 1;
        cabine_re420_fahrschalter_test_fahren_punkt_P7 = 1;
        cabine_re420_fahrschalter_test_fahren_punkt_P3 = 0;
        cabine_re420_fahrschalter_test_fahren_punkt_end = 0;
        cabine_re420_wendeschalter_$wendeschalter_V = 0;
        cabine_re420_wendeschalter_$wendeschalter_0 = 1;
        cabine_re420_wendeschalter_$wendeschalter_R = 0;
        cabine_re420_hauptschalter_$hauptschalter_ein = 0;
        cabine_re420_wendeschalter_controller_$140a = 0;
        cabine_re420_wendeschalter_controller_$140b = 0;
        cabine_re420_stromabnehmer_$stromabnehmer_tief = 1;
        cabine_re420_hauptschalter_$hauptschalter_aus = 1;
        cabine_re420_hauptschalter_controller_$S132 = 0;
        cabine_re420_stromabnehmer_$stromabnehmer_hoch = 0;
        cabine_re420_stromabnehmer_controller_$S129 = 0;
        cabine_re420_kompressor_$kompressor_0 = 1;
        cabine_re420_kompressor_$kompressor_d = 0;
        cabine_re420_kompressor_controller_$XXXXX = 0;
        cabine_re420_kompressor_$kompressor_A = 0;
        cabine_re420_kompressor_controller_$XXXX = 0;
        cabine_re420_zugsammelschiene_$zusammelschiene_ein = 0;
        cabine_re420_zugsammelschiene_$zusammelschiene_aus = 1;
        cabine_re420_totmannpedal_$off = 1;
        cabine_re420_zugsammelschiene_controller_$S169 = 0;
        cabine_re420_totmannpedal_$on = 0;
        cabine_re420_totmannpedal_controller_$S235 = 0;
        cabine_re420_fahrschalter_controller_$set_bremsen_plus = 0;
        cabine_re420_fahrschalter_controller_$set_fahren_m = 0;
        cabine_re420_fahrschalter_controller_$s150g = 0;
        cabine_re420_fahrschalter_controller_$s150l = 0;
        cabine_re420_fahrschalter_controller_$s150d = 0;
        cabine_re420_fahrschalter_controller_$s150a = 0;
        cabine_re420_fahrschalter_controller_$set_fahren_minus = 0;
        cabine_re420_fahrschalter_controller_$set_fahren_punkt = 0;
        cabine_re420_fahrschalter_controller_$s150e = 0;
        cabine_re420_fahrschalter_controller_$s150f = 0;
    }
    public boolean fireOneTransition() {
        //check if cabine_re420_fahrschalter_controller_T17 can fire
        if ( (cabine_re420_fahrschalter_controller_$neutral <= 0) &&
                (cabine_re420_fahrschalter_controller_$neutral_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$set_neutral >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T17"))
            {
                ++cabine_re420_fahrschalter_controller_$neutral;
                --cabine_re420_fahrschalter_controller_$neutral_aus;
                fire("cabine_re420_fahrschalter_controller_T17");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T16 can fire
        if ( (cabine_re420_fahrschalter_controller_$neutral >= 1) &&
                (cabine_re420_fahrschalter_controller_$neutral_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_neutral < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T16"))
            {
                --cabine_re420_fahrschalter_controller_$neutral;
                ++cabine_re420_fahrschalter_controller_$neutral_aus;
                fire("cabine_re420_fahrschalter_controller_T16");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T18 can fire
        if ( (cabine_re420_fahrschalter_controller_$set_fahren_minus < 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_minus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_minus_aus <= 0))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T18"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_minus;
                ++cabine_re420_fahrschalter_controller_$fahren_minus_aus;
                fire("cabine_re420_fahrschalter_controller_T18");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T19 can fire
        if ( (cabine_re420_fahrschalter_controller_$set_fahren_minus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_minus <= 0) &&
                (cabine_re420_fahrschalter_controller_$fahren_minus_aus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T19"))
            {
                ++cabine_re420_fahrschalter_controller_$fahren_minus;
                --cabine_re420_fahrschalter_controller_$fahren_minus_aus;
                fire("cabine_re420_fahrschalter_controller_T19");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T20 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_punkt >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_punkt_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_punkt < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T20"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_punkt;
                ++cabine_re420_fahrschalter_controller_$fahren_punkt_aus;
                fire("cabine_re420_fahrschalter_controller_T20");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T21 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_punkt_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_punkt <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T21"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_punkt_aus;
                ++cabine_re420_fahrschalter_controller_$fahren_punkt;
                fire("cabine_re420_fahrschalter_controller_T21");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T22 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_m_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$fahren_m >= 1) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_m < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T22"))
            {
                ++cabine_re420_fahrschalter_controller_$fahren_m_aus;
                --cabine_re420_fahrschalter_controller_$fahren_m;
                fire("cabine_re420_fahrschalter_controller_T22");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T23 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_m_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_m <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_m >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T23"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_m_aus;
                ++cabine_re420_fahrschalter_controller_$fahren_m;
                fire("cabine_re420_fahrschalter_controller_T23");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T24 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_plus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_plus_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_plus < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T24"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_plus;
                ++cabine_re420_fahrschalter_controller_$fahren_plus_aus;
                fire("cabine_re420_fahrschalter_controller_T24");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T35 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_plus <= 0) &&
                (cabine_re420_fahrschalter_controller_$fahren_plus_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_plus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T35"))
            {
                ++cabine_re420_fahrschalter_controller_$fahren_plus;
                --cabine_re420_fahrschalter_controller_$fahren_plus_aus;
                fire("cabine_re420_fahrschalter_controller_T35");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T26 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_plusplus_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$fahren_plusplus >= 1) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_plusplus < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T26"))
            {
                ++cabine_re420_fahrschalter_controller_$fahren_plusplus_aus;
                --cabine_re420_fahrschalter_controller_$fahren_plusplus;
                fire("cabine_re420_fahrschalter_controller_T26");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T27 can fire
        if ( (cabine_re420_fahrschalter_controller_$fahren_plusplus_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$fahren_plusplus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_fahren_plusplus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T27"))
            {
                --cabine_re420_fahrschalter_controller_$fahren_plusplus_aus;
                ++cabine_re420_fahrschalter_controller_$fahren_plusplus;
                fire("cabine_re420_fahrschalter_controller_T27");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T14 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_minus >= 1) &&
                (cabine_re420_fahrschalter_controller_$bremsen_minus_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_minus < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T14"))
            {
                --cabine_re420_fahrschalter_controller_$bremsen_minus;
                ++cabine_re420_fahrschalter_controller_$bremsen_minus_aus;
                fire("cabine_re420_fahrschalter_controller_T14");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T15 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_minus_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$bremsen_minus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T15"))
            {
                --cabine_re420_fahrschalter_controller_$bremsen_minus_aus;
                ++cabine_re420_fahrschalter_controller_$bremsen_minus;
                fire("cabine_re420_fahrschalter_controller_T15");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T12 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_punkt >= 1) &&
                (cabine_re420_fahrschalter_controller_$bremsen_punkt_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_punkt < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T12"))
            {
                --cabine_re420_fahrschalter_controller_$bremsen_punkt;
                ++cabine_re420_fahrschalter_controller_$bremsen_punkt_aus;
                fire("cabine_re420_fahrschalter_controller_T12");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T13 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_punkt_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$bremsen_punkt <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T13"))
            {
                --cabine_re420_fahrschalter_controller_$bremsen_punkt_aus;
                ++cabine_re420_fahrschalter_controller_$bremsen_punkt;
                fire("cabine_re420_fahrschalter_controller_T13");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T10 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_plus >= 1) &&
                (cabine_re420_fahrschalter_controller_$bremsen_plus_aus <= 0) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_plus < 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T10"))
            {
                --cabine_re420_fahrschalter_controller_$bremsen_plus;
                ++cabine_re420_fahrschalter_controller_$bremsen_plus_aus;
                fire("cabine_re420_fahrschalter_controller_T10");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_controller_T11 can fire
        if ( (cabine_re420_fahrschalter_controller_$bremsen_plus <= 0) &&
                (cabine_re420_fahrschalter_controller_$bremsen_plus_aus >= 1) &&
                (cabine_re420_fahrschalter_controller_$set_bremsen_plus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_controller_T11"))
            {
                ++cabine_re420_fahrschalter_controller_$bremsen_plus;
                --cabine_re420_fahrschalter_controller_$bremsen_plus_aus;
                fire("cabine_re420_fahrschalter_controller_T11");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_T8 can fire
        if ( (cabine_re420_fahrschalter_test_enabled >= 1) &&
                (cabine_re420_fahrschalter_test_neutral <= 0))
        {
            if (canFire("cabine_re420_fahrschalter_test_T8"))
            {
                --cabine_re420_fahrschalter_test_enabled;
                ++cabine_re420_fahrschalter_test_neutral;
                fire("cabine_re420_fahrschalter_test_T8");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_T11 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus <= 0) &&
                (cabine_re420_fahrschalter_test_neutral >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_T11"))
            {
                ++cabine_re420_fahrschalter_test_fahren_minus;
                --cabine_re420_fahrschalter_test_neutral;
                fire("cabine_re420_fahrschalter_test_T11");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_T1 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus_end >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_T1"))
            {
                --cabine_re420_fahrschalter_test_fahren_minus;
                ++cabine_re420_fahrschalter_test_fahren_punkt;
                fire("cabine_re420_fahrschalter_test_T1");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_T2 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt_end >= 1) &&
                (cabine_re420_fahrschalter_test_end <= 0))
        {
            if (canFire("cabine_re420_fahrschalter_test_T2"))
            {
                --cabine_re420_fahrschalter_test_fahren_punkt;
                ++cabine_re420_fahrschalter_test_end;
                fire("cabine_re420_fahrschalter_test_T2");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T6 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus_P6 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150f <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T6"))
            {
                ++cabine_re420_fahrschalter_controller_$s150f;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T6");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T3 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus_P3 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150d <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T3"))
            {
                ++cabine_re420_fahrschalter_controller_$s150d;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T3");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T5 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150l <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus_P5 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T5"))
            {
                ++cabine_re420_fahrschalter_controller_$s150l;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T5");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T1 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus_P1 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150a <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T1"))
            {
                ++cabine_re420_fahrschalter_controller_$s150a;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T1");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T2 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150b <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus_P2 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T2"))
            {
                ++cabine_re420_fahrschalter_controller_$s150b;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T2");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T4 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_minus_P4 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150e <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T4"))
            {
                ++cabine_re420_fahrschalter_controller_$s150e;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T4");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T7 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150g <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus_P7 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T7"))
            {
                ++cabine_re420_fahrschalter_controller_$s150g;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T7");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T8 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150a < 1) &&
                (cabine_re420_fahrschalter_controller_$s150b >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150d < 1) &&
                (cabine_re420_fahrschalter_controller_$s150e < 1) &&
                (cabine_re420_fahrschalter_controller_$s150l >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150f < 1) &&
                (cabine_re420_fahrschalter_controller_$s150g < 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus_end <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T8"))
            {
                ++cabine_re420_fahrschalter_test_fahren_minus_end;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T8");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T15 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150a >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T15"))
            {
                --cabine_re420_fahrschalter_controller_$s150a;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T15");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T16 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150d >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T16"))
            {
                --cabine_re420_fahrschalter_controller_$s150d;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T16");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T17 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150e >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T17"))
            {
                --cabine_re420_fahrschalter_controller_$s150e;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T17");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T18 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150f >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T18"))
            {
                --cabine_re420_fahrschalter_controller_$s150f;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T18");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_minus_T19 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150g >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_minus >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_minus_T19"))
            {
                --cabine_re420_fahrschalter_controller_$s150g;
                fire("cabine_re420_fahrschalter_test_fahren_minus_T19");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T6 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt_P6 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150f <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T6"))
            {
                ++cabine_re420_fahrschalter_controller_$s150f;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T6");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T3 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150d <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt_P3 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T3"))
            {
                ++cabine_re420_fahrschalter_controller_$s150d;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T3");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T5 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150l <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt_P5 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T5"))
            {
                ++cabine_re420_fahrschalter_controller_$s150l;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T5");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T1 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt_P1 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150a <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T1"))
            {
                ++cabine_re420_fahrschalter_controller_$s150a;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T1");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T2 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150b <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt_P2 >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T2"))
            {
                ++cabine_re420_fahrschalter_controller_$s150b;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T2");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T4 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt_P4 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150e <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T4"))
            {
                ++cabine_re420_fahrschalter_controller_$s150e;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T4");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T7 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt_P7 >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150g <= 0) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T7"))
            {
                ++cabine_re420_fahrschalter_controller_$s150g;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T7");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T10 can fire
        if ( (cabine_re420_fahrschalter_test_fahren_punkt_end <= 0) &&
                (cabine_re420_fahrschalter_controller_$s150a < 1) &&
                (cabine_re420_fahrschalter_controller_$s150d < 1) &&
                (cabine_re420_fahrschalter_controller_$s150e < 1) &&
                (cabine_re420_fahrschalter_controller_$s150l < 1) &&
                (cabine_re420_fahrschalter_controller_$s150b >= 1) &&
                (cabine_re420_fahrschalter_controller_$s150f < 1) &&
                (cabine_re420_fahrschalter_controller_$s150g >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T10"))
            {
                ++cabine_re420_fahrschalter_test_fahren_punkt_end;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T10");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T14 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150a >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T14"))
            {
                --cabine_re420_fahrschalter_controller_$s150a;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T14");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T15 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150d >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T15"))
            {
                --cabine_re420_fahrschalter_controller_$s150d;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T15");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T16 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150e >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T16"))
            {
                --cabine_re420_fahrschalter_controller_$s150e;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T16");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T17 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150l >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T17"))
            {
                --cabine_re420_fahrschalter_controller_$s150l;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T17");
                return true;
            }
        }
        //check if cabine_re420_fahrschalter_test_fahren_punkt_T18 can fire
        if ( (cabine_re420_fahrschalter_controller_$s150f >= 1) &&
                (cabine_re420_fahrschalter_test_fahren_punkt >= 1))
        {
            if (canFire("cabine_re420_fahrschalter_test_fahren_punkt_T18"))
            {
                --cabine_re420_fahrschalter_controller_$s150f;
                fire("cabine_re420_fahrschalter_test_fahren_punkt_T18");
                return true;
            }
        }
        //check if cabine_re420_wendeschalter_T6 can fire
        if ( (cabine_re420_wendeschalter_controller_$140a < 1) &&
                (cabine_re420_wendeschalter_$wendeschalter_0 <= 0) &&
                (cabine_re420_wendeschalter_$wendeschalter_V >= 1))
        {
            if (canFire("cabine_re420_wendeschalter_T6"))
            {
                ++cabine_re420_wendeschalter_$wendeschalter_0;
                --cabine_re420_wendeschalter_$wendeschalter_V;
                fire("cabine_re420_wendeschalter_T6");
                return true;
            }
        }
        //check if cabine_re420_wendeschalter_T7 can fire
        if ( (cabine_re420_wendeschalter_$wendeschalter_R <= 0) &&
                (cabine_re420_wendeschalter_controller_$140b >= 1) &&
                (cabine_re420_wendeschalter_$wendeschalter_0 >= 1))
        {
            if (canFire("cabine_re420_wendeschalter_T7"))
            {
                ++cabine_re420_wendeschalter_$wendeschalter_R;
                --cabine_re420_wendeschalter_$wendeschalter_0;
                fire("cabine_re420_wendeschalter_T7");
                return true;
            }
        }
        //check if cabine_re420_wendeschalter_T8 can fire
        if ( (cabine_re420_wendeschalter_$wendeschalter_R >= 1) &&
                (cabine_re420_wendeschalter_$wendeschalter_0 <= 0) &&
                (cabine_re420_wendeschalter_controller_$140b < 1))
        {
            if (canFire("cabine_re420_wendeschalter_T8"))
            {
                --cabine_re420_wendeschalter_$wendeschalter_R;
                ++cabine_re420_wendeschalter_$wendeschalter_0;
                fire("cabine_re420_wendeschalter_T8");
                return true;
            }
        }
        //check if cabine_re420_wendeschalter_T9 can fire
        if ( (cabine_re420_wendeschalter_$wendeschalter_0 >= 1) &&
                (cabine_re420_wendeschalter_controller_$140a >= 1) &&
                (cabine_re420_wendeschalter_$wendeschalter_V <= 0))
        {
            if (canFire("cabine_re420_wendeschalter_T9"))
            {
                --cabine_re420_wendeschalter_$wendeschalter_0;
                ++cabine_re420_wendeschalter_$wendeschalter_V;
                fire("cabine_re420_wendeschalter_T9");
                return true;
            }
        }
        //check if cabine_re420_hauptschalter_T1 can fire
        if ( (cabine_re420_hauptschalter_$hauptschalter_aus <= 0) &&
                (cabine_re420_hauptschalter_controller_$S132 < 1) &&
                (cabine_re420_hauptschalter_$hauptschalter_ein >= 1))
        {
            if (canFire("cabine_re420_hauptschalter_T1"))
            {
                ++cabine_re420_hauptschalter_$hauptschalter_aus;
                --cabine_re420_hauptschalter_$hauptschalter_ein;
                fire("cabine_re420_hauptschalter_T1");
                return true;
            }
        }
        //check if cabine_re420_hauptschalter_T2 can fire
        if ( (cabine_re420_hauptschalter_$hauptschalter_aus >= 1) &&
                (cabine_re420_hauptschalter_controller_$S132 >= 1) &&
                (cabine_re420_hauptschalter_$hauptschalter_ein <= 0))
        {
            if (canFire("cabine_re420_hauptschalter_T2"))
            {
                --cabine_re420_hauptschalter_$hauptschalter_aus;
                ++cabine_re420_hauptschalter_$hauptschalter_ein;
                fire("cabine_re420_hauptschalter_T2");
                return true;
            }
        }
        //check if cabine_re420_stromabnehmer_T1 can fire
        if ( (cabine_re420_stromabnehmer_$stromabnehmer_hoch >= 1) &&
                (cabine_re420_stromabnehmer_controller_$S129 < 1) &&
                (cabine_re420_stromabnehmer_$stromabnehmer_tief <= 0))
        {
            if (canFire("cabine_re420_stromabnehmer_T1"))
            {
                --cabine_re420_stromabnehmer_$stromabnehmer_hoch;
                ++cabine_re420_stromabnehmer_$stromabnehmer_tief;
                fire("cabine_re420_stromabnehmer_T1");
                return true;
            }
        }
        //check if cabine_re420_stromabnehmer_T2 can fire
        if ( (cabine_re420_stromabnehmer_controller_$S129 >= 1) &&
                (cabine_re420_stromabnehmer_$stromabnehmer_tief >= 1) &&
                (cabine_re420_stromabnehmer_$stromabnehmer_hoch <= 0))
        {
            if (canFire("cabine_re420_stromabnehmer_T2"))
            {
                --cabine_re420_stromabnehmer_$stromabnehmer_tief;
                ++cabine_re420_stromabnehmer_$stromabnehmer_hoch;
                fire("cabine_re420_stromabnehmer_T2");
                return true;
            }
        }
        //check if cabine_re420_kompressor_T6 can fire
        if ( (cabine_re420_kompressor_$kompressor_A >= 1) &&
                (cabine_re420_kompressor_$kompressor_0 <= 0) &&
                (cabine_re420_kompressor_controller_$XXXX < 1))
        {
            if (canFire("cabine_re420_kompressor_T6"))
            {
                --cabine_re420_kompressor_$kompressor_A;
                ++cabine_re420_kompressor_$kompressor_0;
                fire("cabine_re420_kompressor_T6");
                return true;
            }
        }
        //check if cabine_re420_kompressor_T8 can fire
        if ( (cabine_re420_kompressor_$kompressor_d >= 1) &&
                (cabine_re420_kompressor_$kompressor_0 <= 0) &&
                (cabine_re420_kompressor_controller_$XXXXX < 1))
        {
            if (canFire("cabine_re420_kompressor_T8"))
            {
                --cabine_re420_kompressor_$kompressor_d;
                ++cabine_re420_kompressor_$kompressor_0;
                fire("cabine_re420_kompressor_T8");
                return true;
            }
        }
        //check if cabine_re420_kompressor_T9 can fire
        if ( (cabine_re420_kompressor_$kompressor_0 >= 1) &&
                (cabine_re420_kompressor_controller_$XXXX >= 1) &&
                (cabine_re420_kompressor_$kompressor_A <= 0))
        {
            if (canFire("cabine_re420_kompressor_T9"))
            {
                --cabine_re420_kompressor_$kompressor_0;
                ++cabine_re420_kompressor_$kompressor_A;
                fire("cabine_re420_kompressor_T9");
                return true;
            }
        }
        //check if cabine_re420_kompressor_T7 can fire
        if ( (cabine_re420_kompressor_$kompressor_0 >= 1) &&
                (cabine_re420_kompressor_controller_$XXXXX >= 1) &&
                (cabine_re420_kompressor_$kompressor_d <= 0))
        {
            if (canFire("cabine_re420_kompressor_T7"))
            {
                --cabine_re420_kompressor_$kompressor_0;
                ++cabine_re420_kompressor_$kompressor_d;
                fire("cabine_re420_kompressor_T7");
                return true;
            }
        }
        //check if cabine_re420_zugsammelschiene_T1 can fire
        if ( (cabine_re420_zugsammelschiene_$zusammelschiene_ein >= 1) &&
                (cabine_re420_zugsammelschiene_$zusammelschiene_aus <= 0) &&
                (cabine_re420_zugsammelschiene_controller_$S169 < 1))
        {
            if (canFire("cabine_re420_zugsammelschiene_T1"))
            {
                --cabine_re420_zugsammelschiene_$zusammelschiene_ein;
                ++cabine_re420_zugsammelschiene_$zusammelschiene_aus;
                fire("cabine_re420_zugsammelschiene_T1");
                return true;
            }
        }
        //check if cabine_re420_zugsammelschiene_T2 can fire
        if ( (cabine_re420_zugsammelschiene_controller_$S169 >= 1) &&
                (cabine_re420_zugsammelschiene_$zusammelschiene_ein <= 0) &&
                (cabine_re420_zugsammelschiene_$zusammelschiene_aus >= 1))
        {
            if (canFire("cabine_re420_zugsammelschiene_T2"))
            {
                ++cabine_re420_zugsammelschiene_$zusammelschiene_ein;
                --cabine_re420_zugsammelschiene_$zusammelschiene_aus;
                fire("cabine_re420_zugsammelschiene_T2");
                return true;
            }
        }
        //check if cabine_re420_totmannpedal_T1 can fire
        if ( (cabine_re420_totmannpedal_$on >= 1) &&
                (cabine_re420_totmannpedal_$off <= 0) &&
                (cabine_re420_totmannpedal_controller_$S235 < 1))
        {
            if (canFire("cabine_re420_totmannpedal_T1"))
            {
                --cabine_re420_totmannpedal_$on;
                ++cabine_re420_totmannpedal_$off;
                fire("cabine_re420_totmannpedal_T1");
                return true;
            }
        }
        //check if cabine_re420_totmannpedal_T2 can fire
        if ( (cabine_re420_totmannpedal_$off >= 1) &&
                (cabine_re420_totmannpedal_$on <= 0) &&
                (cabine_re420_totmannpedal_controller_$S235 >= 1))
        {
            if (canFire("cabine_re420_totmannpedal_T2"))
            {
                --cabine_re420_totmannpedal_$off;
                ++cabine_re420_totmannpedal_$on;
                fire("cabine_re420_totmannpedal_T2");
                return true;
            }
        }
        return false;
    }
    public boolean calcBooleanPlaces() {

        cabine_re420_fahrschalter_controller_$set_fahren_plusplus = (
                (cabine_re420_fahrschalter_controller_$s150b >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150f >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150e >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150l >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_bremsen_minus = (
                (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e < 1)
                        && (cabine_re420_fahrschalter_controller_$s150l >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150g < 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150b < 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_bremsen_punkt = (
                (cabine_re420_fahrschalter_controller_$s150b < 1)
                        && (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150l < 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_fahren_plus = (
                (cabine_re420_fahrschalter_controller_$s150b >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150e >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150l < 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_neutral = (
                (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150l < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g < 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150b < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e < 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_bremsen_plus = (
                (cabine_re420_fahrschalter_controller_$s150b < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150l >= 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_fahren_m = (
                (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150l >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150d >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150b >= 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_fahren_minus = (
                (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g < 1)
                        && (cabine_re420_fahrschalter_controller_$s150l >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150b >= 1) ) == true ? 1 : 0;

        cabine_re420_fahrschalter_controller_$set_fahren_punkt = (
                (cabine_re420_fahrschalter_controller_$s150b >= 1)
                        && (cabine_re420_fahrschalter_controller_$s150f < 1)
                        && (cabine_re420_fahrschalter_controller_$s150e < 1)
                        && (cabine_re420_fahrschalter_controller_$s150d < 1)
                        && (cabine_re420_fahrschalter_controller_$s150a < 1)
                        && (cabine_re420_fahrschalter_controller_$s150l < 1)
                        && (cabine_re420_fahrschalter_controller_$s150g >= 1) ) == true ? 1 : 0;
        return true;
    }
}