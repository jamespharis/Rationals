package com.cooksys.ftd.assignments.objects;

public class SimplifiedRational implements IRational {
	
	private int numerator;
	private int denominator;
	
	
/* Determines the greatest common denominator for the given values // using Euclid Algorithm
 * @param - a - the first value to consider
 * @param - b - the second value to consider
 * @return the greatest common denominator, or shared factor, of `a` and `b`
 * @throws IllegalArgumentException if a < 0 or b < 0												*/
    public static int gcd(int a, int b) throws IllegalArgumentException { 
    	if((a < 0) || (b < 0)) { throw new IllegalArgumentException(); }
    	while ( b != 0)
    	  { int t = b;
    		b = a % b;  
    		a = t;
    	  }
    	return a;
    } 

    

/* Simplifies the numerator and denominator of a rational value.
 * For example: `simplify(10, 100) = [1, 10]`		or: `simplify(0, 10) = [0, 1]`
 * @param - numerator - the numerator of the rational value to simplify
 * @param - denominator - the denominator of the rational value to simplify
 * @return a two element array representation of the simplified numerator and denominator
 * @throws IllegalArgumentException if the given denominator is 0										 */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	int sim = gcd(Math.abs(numerator), Math.abs(denominator));
		return new int[] {numerator / sim, denominator / sim}; // Created array(fraction) with numerator & denominator
    }
/*	OLD CODE
 * 		int x = gcd(Math.abs(numerator), Math.abs(denominator));
 * 		//populate simplify numbers with whatever gcd you get back
 * 		int[] simplified = new int[2];
 * 		simplified[0] = numerator/x; //USING X: divide numerator & denominator by x to simplify them
 * 		simplified[1] = denominator/x;
 * 		return simplified; // return array of the simplified rational
 	}*/    

    

/* Constructor for rational values of the type: `numerator / denominator`
 * Simplification of numerator/denominator pair should occur in this method.
 * If the numerator is zero, no further simplification can be performed
 * @param - numerator - the numerator of the rational value
 * @param - denominator - the denominator of the rational value
 * @throws IllegalArgumentException if the given denominator is 0						*/
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) { throw new IllegalArgumentException(); }
    	int[] simplified = simplify(numerator, denominator);
    	this.numerator = simplified[0];
        this.denominator = simplified[1];
    }


    @Override
    public int getNumerator() { return numerator; }

    @Override
    public int getDenominator() { return denominator; }

    
/* Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
 * This method allows us to implement most of IRational methods directly in the interface while preserving the underlying type
 * @param - numerator - the numerator of the rational value to construct
 * @param - denominator - the denominator of the rational value to construct
 * @return the constructed rational value (specifically, a SimplifiedRational value)
 * @throws IllegalArgumentException if the given denominator is 0
*/  @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException 
    {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	return new SimplifiedRational(numerator, denominator);
    }

    

	@Override // AUTO-GENERATED hashCode
	public int hashCode() {
//		return Objects.hash(denominator, numerator);
		final int prime = 31;
		int result = 1;
		result = prime * result + denominator;
		result = prime * result + numerator;
		return result;
	}
/*  @param - obj - the object to check this against for equality
 *  @return true if the given object is a Simplified Rational value &... 
 *  ...& its numerator and denominator are equal to this rational value's numerator and denominator, false otherwise
*/  @Override
    public boolean equals(Object obj) {
		if (this == obj) { return true; } // check if our object is the same as itself
		if (obj instanceof IRational) { // checking if Rational or SimplifiedRational
			IRational other = (IRational) obj; // creating 'other' to cast 'obj' to IRational
			return this.numerator == other.getNumerator() && this.denominator == other.getDenominator(); 
			// ONLY return true if numerators AND denominators match
		}
		return false;
	}
    


/* If this is positive, the string should be of the form `numerator/denominator`
 * If this is negative, the string should be of the form `-numerator/denominator`
 *  @return a string representation of this rational value
*/  @Override	// basic toString returns memory address
    public String toString() {
		if (numerator < 0 != denominator < 0) // Asking if they are different... negative if BOTH + or -
		{ return "-" + Math.abs(numerator) + "/" + Math.abs(denominator); }
		return Math.abs(numerator) + "/" + Math.abs(denominator);
	}
}
