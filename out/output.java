abstract class Supervised_System  {
    static AadlMemoryObject<Double> timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Boolean> p1 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> p2 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> p3 = new AadlMemoryObject<Boolean>();

    
    void checked_Supervised_System() {
        unchecked_Supervised_System();
        assert  p1.get() ;
        assert  p2.get() ;
        assert  p3.get() ;
    }
    

    
    abstract void unchecked_Supervised_System();
    


}

class checked_Supervised_System extends Supervised_System {

    
    void unchecked_Supervised_System() {
    }
    


}

abstract class GeoFence_singleton  {
    static AadlMemoryObject<Double> timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> t = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> distanceFromFence = new AadlMemoryObject<Double>();

    
    void checked_GeoFence_singleton() {
        t:real = 0.0-> AadlUtil.pre(t) +0.1;
        unchecked_GeoFence_singleton();
        assert (!(( t.get() >= timeToRecovery.get() )) || (( distanceFromFence.get() >AadlUtil.pre(distanceFromFence))));
        assert  timeToRecovery.get() ==1.7;
        assert  timeToFailure.get() ==9.5;
        assert  t.get() ==4+4+4+4+4;
        Supervisor.geof_timeToRecovery.set(timeToRecovery.get());
        Supervisor.geof_timeToFailure.set(timeToFailure.get());
    }
    

    
    abstract void unchecked_GeoFence_singleton();
    


}

class checked_GeoFence_singleton extends GeoFence_singleton {

    
    void unchecked_GeoFence_singleton() {
    }
    


}

abstract class TCAS_singleton  {
    static AadlMemoryObject<Integer> nearestIntruderAltitude = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> nearestIntruderGroundDistance = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> nearestIntruderLongitude = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> ownAltitude_in = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> ownHeading = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> ownVerticalVelocity = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> ownLatitude = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> ownLongitude = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> requiredVerticalVelocity = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Double> timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> t = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Integer> ownAltitude = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Boolean> intrusionSurfaceTop = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> ownAircraftGoesUpOnTie = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> threatDetected = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Integer> altitude_diff = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> sameAltitudeGoUp = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> sameAltitudeGoDown = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> intrustionFromAbove = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> intrustionFromBelow = new AadlMemoryObject<Integer>();
    static AadlMemoryObject<Integer> safeAltitudeDifference = new AadlMemoryObject<Integer>();

    
    void checked_TCAS_singleton() {
        t:real = 0.0->AadlUtil.pre(t)+1.0;
        ownAltitude:int =  ownAltitude_in.get() ->AadlUtil.pre(ownAltitude)+AadlUtil.pre(requiredVerticalVelocity);
        intrusionSurfaceTop:bool =  True.get() ;
        altitude_diff:int = tcas_nodes.abs_diff( ownAltitude.get() , nearestIntruderAltitude.get() );
        sameAltitudeGoUp:int = 50;
        sameAltitudeGoDown:int = -50;
        intrustionFromAbove:int = -10;
        intrustionFromBelow:int = 10;
        safeAltitudeDifference:int = 100;
        unchecked_TCAS_singleton();
        assert (!(( t.get() >= timeToRecovery.get() )) || (( altitude_diff.get() >= safeAltitudeDifference.get() )));
        assert  timeToRecovery.get() ==9.1;
        assert  timeToFailure.get() ==15.0;
        Supervisor.tcas_timeToRecovery.set(timeToRecovery.get());
        Supervisor.tcas_timeToFailure.set(timeToFailure.get());
    }
    

    
    abstract void unchecked_TCAS_singleton();
    


}

class checked_TCAS_singleton extends TCAS_singleton {

    
    void unchecked_TCAS_singleton() {
    }
    


}

abstract class GCAS_singleton  {
    static AadlMemoryObject<Double> altitude = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> t = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> height = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> minHeightAllowed = new AadlMemoryObject<Double>();

    
    void checked_GCAS_singleton() {
        t:real = 0.0->AadlUtil.pre(t)+0.1;
        minHeightAllowed:real = 200.0;
        unchecked_GCAS_singleton();
        assert (!(( t.get() >= timeToRecovery.get() )) || ((( height.get() > minHeightAllowed.get() )&&( height.get() >AadlUtil.pre(height)))));
        assert  timeToRecovery.get() ==8.7;
        assert  timeToFailure.get() ==16.0;
        Supervisor.gcas_timeToRecovery.set(timeToRecovery.get());
        Supervisor.gcas_timeToFailure.set(timeToFailure.get());
    }
    

    
    abstract void unchecked_GCAS_singleton();
    


}

class checked_GCAS_singleton extends GCAS_singleton {

    
    void unchecked_GCAS_singleton() {
    }
    


}

abstract class Supervisor  {
    static AadlMemoryObject<Double> gcas_timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> tcas_timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> geof_timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToFailure = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> gcas_timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> tcas_timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> geof_timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Double> timeToRecovery = new AadlMemoryObject<Double>();
    static AadlMemoryObject<Boolean> p1 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> p2 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> p3 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> c1 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> c2 = new AadlMemoryObject<Boolean>();
    static AadlMemoryObject<Boolean> c3 = new AadlMemoryObject<Boolean>();

    
    void checked_Supervisor() {
        c1:bool = composite_nodes.concurrencyFactor( gcas_timeToRecovery.get() , tcas_timeToRecovery.get() , geof_timeToRecovery.get() , timeToFailure.get() );
        c2:bool = composite_nodes.concurrencyFactor( gcas_timeToRecovery.get() , tcas_timeToRecovery.get() , geof_timeToRecovery.get() , timeToFailure.get() );
        c3:bool = composite_nodes.concurrencyFactor( gcas_timeToRecovery.get() , tcas_timeToRecovery.get() , geof_timeToRecovery.get() , timeToFailure.get() );
        unchecked_Supervisor();
        assert  timeToFailure.get() ==composite_nodes.min( gcas_timeToFailure.get() , tcas_timeToFailure.get() , geof_timeToFailure.get() );
        assert  p1.get() == c1.get() ;
        assert  p2.get() == c2.get() ;
        assert  p3.get() == c3.get() ;
        Supervised_System.timeToFailure.set(timeToFailure.get());
        Supervised_System.timeToRecovery.set(timeToRecovery.get());
        Supervised_System.p1.set(p1.get());
        Supervised_System.p2.set(p2.get());
        Supervised_System.p3.set(p3.get());
    }
    

    
    abstract void unchecked_Supervisor();
    


}

class checked_Supervisor extends Supervisor {

    
    void unchecked_Supervisor() {
    }
    


}
    class AadlMemoryObject <T> {
        private T payload = null;
        private T previous = null;
        private boolean hasPayload = false;
        private boolean hasPrevious = false;
    
        public void set(T payload) {
            this.previous = this.payload;
            this.payload = payload;
            if (hasPayload) {
                hasPrevious = true;
            }
            hasPayload = true;
        }
    
        public T get() {
            if (!hasPayload) {
                throw new RuntimeException("Aadl variable never set!");
            } else {
                return payload;
            }
        }
    
        public T previous() {
            if (!hasPrevious) {
                throw new RuntimeException("Aadl varible never set!");
            } else {
                return previous;
            }
        }
        
        public boolean hasPrevious() {
            return hasPrevious;
        }
    }
    
    class AadlUtil {
        public static <T> T pre(AadlMemoryObject<T> aadlField) {
            return aadlField.previous();
        }
    }
    class aviation  {

    
    public static ConcurrencyFactor concurrencyFactor(Double t0, Double t1, Double t2, Double totalTime) {
        Boolean can_use_1 = ((t0 + (t1 + t2)) < totalTime);
        Boolean can_use_2 = (((t0 < totalTime) && ((t1 + t2) < totalTime)) || ((((t0 + t1) < totalTime) && (t2 < totalTime)) || ((t1 < totalTime) && ((t0 + t2) < totalTime))));
        Boolean can_use_3 = ((t0 < totalTime) && ((t1 < totalTime) && (t2 < totalTime)));
        return new ConcurrencyFactor(can_use_1, can_use_2, can_use_3);
    }
    

    
    public static Min min(Double num0, Double num1, Double num2) {
        Double min = ((num0 < num1)) ? (
        ((num0 < num2)) ? (
            num0
        ) : (
            num2
        )
    ) : (
        ((num1 < num2)) ? (
            num1
        ) : (
            num2
        )
    );
        return new Min(min);
    }
    


}

class ConcurrencyFactor  {
    Boolean can_use_1;
    Boolean can_use_2;
    Boolean can_use_3;

    
    public  ConcurrencyFactor(Boolean can_use_1, Boolean can_use_2, Boolean can_use_3) {
        this.can_use_1 = can_use_1;
        this.can_use_2 = can_use_2;
        this.can_use_3 = can_use_3;
    }
    


}

class Min  {
    Double min;

    
    public  Min(Double min) {
        this.min = min;
    }
    


}

class composite_nodes  {

    
    public static ConcurrencyFactor concurrencyFactor(Double t0, Double t1, Double t2, Double totalTime) {
        Boolean can_use_1 = ((t0 + (t1 + t2)) < totalTime);
        Boolean can_use_2 = (((t0 < totalTime) && ((t1 + t2) < totalTime)) || ((((t0 + t1) < totalTime) && (t2 < totalTime)) || ((t1 < totalTime) && ((t0 + t2) < totalTime))));
        Boolean can_use_3 = ((t0 < totalTime) && ((t1 < totalTime) && (t2 < totalTime)));
        return new ConcurrencyFactor(can_use_1, can_use_2, can_use_3);
    }
    

    
    public static Min min(Double num0, Double num1, Double num2) {
        Double min = ((num0 < num1)) ? (
        ((num0 < num2)) ? (
            num0
        ) : (
            num2
        )
    ) : (
        ((num1 < num2)) ? (
            num1
        ) : (
            num2
        )
    );
        return new Min(min);
    }
    


}