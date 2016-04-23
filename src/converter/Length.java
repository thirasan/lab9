package converter;

public enum Length implements Unit {
	/* Define the members of the enumeration
	 * the attributes are:
	 * name = a string name for this unit,
	 * value = multiplier to convert to meters.
	 */
	METER( "Meter", 1.0),
	FOOT( "Foot", 0.03048),
	MILE( "mile", 1609.344),
	CENTIMETER( "centimeter", 0.01),
	KILLOMETER( "kilometer", 1000.0),
	INCH( "inch" ,0.0254),
	MICRON( "micron",1.0E-6),
	YARD( "yard", 3*3.048),
	WA( "wa", 2.0);
	
	/** name of this unit */
	private final String name;
	/** multiplier to convert this unit to std unit */
	private final double value;
	
	/** Private constructor for enum members */
	private Length(String name, double value){
		this.name = name;
		this.value = value;
	}

	@Override
	public double getValue() {
		return value;
	}
}
