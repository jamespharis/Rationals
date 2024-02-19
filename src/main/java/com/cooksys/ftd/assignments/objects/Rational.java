package com.cooksys.ftd.assignments.objects;

public class Rational implements IRational {
	
	private int numerator;
	private int denominator;
	
	
/* Constructor of rational values of the type: `numerator / denominator`
	No simplification of the numerator/denominator pair should occur in this method.
	@param - numerator - the numerator of the rational value
	@param - denominator - the denominator of the rational value
	@throws IllegalArgumentException if the given denominator is 0			*/							
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0) { throw new IllegalArgumentException(); }
    	this.numerator = numerator;
    	this.denominator = denominator;
    }

    
    
    @Override
    public int getNumerator() { return numerator; }

    @Override
    public int getDenominator() { return denominator; }

    
/* Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
   Essentially, this method allows us to implement most of IRational methods directly in the interface while preserving the underlying type
	@param - numerator - the numerator of the rational value to construct
    @param - denominator - the denominator of the rational value to construct
	@return the constructed rational value
	@throws IllegalArgumentException if the given denominator is 0													
*/  @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	if (denominator == 0 ) { throw new IllegalArgumentException(); }
    	return new Rational(numerator, denominator);
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
	@return true if the given object is a rational value &...
	...& its numerator and denominator are equal to this rational value's numerator and denominator, false otherwise
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
/* CODE COMPARISON & NOTES - - - - - *
 * (obj instanceof IRational) makes check for null & getClass() useless. If not IRational, doesn't matter if null
 * Technically SimplifiedRational, is still a Rational, so we use instanceof IRational to check Rational & SimplifiedRational
*		if (obj == null) { return false; } // make sure our object we are comparing to is not null
*		if (getClass() != obj.getClass()) { return false; }
*		Rational other = (Rational) obj;
*		if (denominator != other.denominator) { return false; }
*		if (numerator != other.numerator) { return false; }
*		return true;
- - - - THIS CODE /\ Does not use nested for loops, making it much simpler
- - - - My CODE \/ used nested for loops to make sure numerator = numerator, then denominator = denominator
*    	Rational RatObj = (Rational) obj;
*    	if(RatObj.getNumerator() == this.getNumerator())		//'this' refers to the object that is calling the method
*    	{ 	
*			if(RatObj.getDenominator() == this.getDenominator()) { return true; }
*    	}
*    	return false;
*    } 
*/



/* If this is positive, the string should be of the form `numerator/denominator`
   If this is negative, the string should be of the form `-numerator/denominator`
	@return a string representation of this rational value
*/  @Override	// basic toString returns memory address
    public String toString() {
		if (numerator < 0 != denominator < 0) // Asking if they are different... negative if BOTH + or -
			{ return "-" + Math.abs(numerator) + "/" + Math.abs(denominator); }
		return Math.abs(numerator) + "/" + Math.abs(denominator);
			
		}
}

/* OLD toString CODE
 * if ((getNumerator() > 0 && getDenominator() > 0)) { return Math.abs(getNumerator())+"/" +Math.abs(getDenominator()); }	//   +/+
 * if ((getNumerator() < 0 && getDenominator() < 0)) { return Math.abs(getNumerator())+"/" +Math.abs(getDenominator()); }	//   -/-
 * if ((getNumerator() < 0 && getDenominator() > 0)) { return getNumerator()+"/" +Math.abs(getDenominator()); }				//   -/+
 * if ((getNumerator() > 0 && getDenominator() < 0)) { return "-"+getNumerator()+"/" +Math.abs(getDenominator()); }			//   +/-
 * return getNumerator()+"/"+getDenominator();
 *  }
 */
