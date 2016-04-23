package converter;

public class UnitConverter {
	public static double convert(double amount,Unit fromUnit,Unit toUnit){
		double x = amount*fromUnit.getValue();
		x = x/toUnit.getValue();
		return x;
	}
	public static Unit[] getUnits(){
		return Length.values();
	}
}
