package primer;

import java.math.BigInteger;

public class NaivePrimeCheck extends PrimeCheck {
	
	public NaivePrimeCheck(String number) {
		super(number);
	}
	
	@Override
	public boolean check() {
		//BigInteger x = 2;
		BigInteger two = new BigInteger("2");
		BigInteger sq = approxSqrt(this.number);
		BigInteger temp;
		for (BigInteger x = new BigInteger("3"); sq.subtract(x).doubleValue() > 0; x.add(two)) {
			temp = this.number.divide(x).multiply(x);
			if (this.number.equals(temp)) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger approxSqrt(BigInteger x2) {
		//babylonian method 
		
		BigInteger x = x2.divide(new BigInteger("10")); //just a guess
		BigInteger xold = x2;
		BigInteger two = new BigInteger("2");
		int k = 0;
		while (xold.subtract(x).doubleValue() > 1) {
			xold = x;
			x = x2.divide(x).add(x);
			x = x.divide(two);
			
			k++;
			
		}
		System.out.println(k);
		return x;
		
	}

	public static void main(String[] args) {
		BigInteger x = approxSqrt(new BigInteger("22185424324123453453434545454"));
		System.out.println(x);;
		NaivePrimeCheck y = new NaivePrimeCheck("137");
		System.out.println(y.check());
	}

}
