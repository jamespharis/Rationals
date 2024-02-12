package com.cooksys.ftd.assignments.objects;

//import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

public class Rational implements IRational {
	private int numerator;
	private int denominator;
	
	
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) { throw new IllegalArgumentException(); }
    	this.numerator = numerator;
    	this.denominator = denominator;
    }

    
    @Override
    public int getNumerator() { return numerator; }

    @Override
    public int getDenominator() { return denominator; }

    
    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	return new Rational(numerator, denominator);
    }

    
    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) { return true; } // check if our object is the same as itself
		if (obj == null) { return false; } // make sure our object is not null
    	if (obj instanceof Rational) // if not same instanceof, then not same class
    	{ 
    	  Rational RatObj = (Rational) obj;
    		if(RatObj.getNumerator() == this.getNumerator()) 
    		{ //'this' refers to the object that is calling the method
    			if(RatObj.getDenominator() == this.getDenominator())
    				{ return true; }
    		}
    	}
    	return false;
    }

    
    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override	// basic toString returns memory address
    public String toString() {
    	if ((getNumerator() > 0 && getDenominator() > 0)) { return Math.abs(getNumerator())+"/" +Math.abs(getDenominator()); }		//   +/+
    	if ((getNumerator() < 0 && getDenominator() < 0)) { return Math.abs(getNumerator())+"/" +Math.abs(getDenominator()); }		//   -/-
    	if ((getNumerator() < 0 && getDenominator() > 0)) { return getNumerator()+"/" +Math.abs(getDenominator()); }				//   -/+
    	if ((getNumerator() > 0 && getDenominator() < 0)) { return "-"+getNumerator()+"/" +Math.abs(getDenominator()); }			//   +/-
    	return getNumerator()+"/"+getDenominator();
        //return "Fraction is undefined or zero.";
    }
}
