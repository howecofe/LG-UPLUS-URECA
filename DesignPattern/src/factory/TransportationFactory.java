package factory;

// XXX Factory (중간자 역할): 보통 Singleton 패턴으로 만든다.
public class TransportationFactory {
	
	public static Transportation getTransportation(String clsf) {
		Transportation t = null;
		
		switch (clsf) {
//			case "Air" : t = AirPlane.getInstance(); break;
			case "Air" : t = Helicopter.getInstance(); break;
//			case "Car" : t = Car.getInstance(); break;
			case "Car" : t = SportsCar.getInstance(); break;
		}
		
		return t;
	}
}
