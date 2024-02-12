package com.cooksys.ftd.assignments.objects;

//import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

public class SimplifiedRational implements IRational {
	
	private int numerator;
	private int denominator;
	
	
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
    	if((a <= 0) || (b < 0)) { throw new IllegalArgumentException(); }
    	while ( b != 0)
    	  { int t = a % b;
    		a = b;  b = t;
    	  }
    	return a;
    } // using Euclid Algorithm

    
    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	int x = gcd(Math.abs(numerator), Math.abs(denominator));
    	//populate simplify numbers with whatever gcd you get back
    	int[] simplified = new int[2];
    	simplified[0] = numerator/x;
    	simplified[1] = denominator/x;
    	//USING X: divivde num & denom by x to simplify them
    	// return array of the simplified rational
    	return simplified;
    	//
        //throw new MissingImplementationException();
    }

    
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) { throw new IllegalArgumentException(); }
    	else if (numerator != 0) 
    	{ 
    		int[] simp = simplify(numerator, denominator);
    		this.numerator = simp[0];
        	this.denominator = simp[1];
        }
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
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException 
    {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	return new SimplifiedRational(numerator, denominator);
    }

    
    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a Simplified Rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	if (this == obj) { return true; } // check if our object is the same as itself
		if (obj == null) { return false; } // make sure our object is not null
    	if (obj instanceof SimplifiedRational) // if not same instanceof, then not same class
    	{ 
    		SimplifiedRational SimRatObj = (SimplifiedRational) obj;
    		if(SimRatObj.getNumerator() == this.getNumerator()) 
    		{ //'this' refers to the object that is calling the method
    			if(SimRatObj.getDenominator() == this.getDenominator())
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
    }
}
