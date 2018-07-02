package primer;
import java.math.BigInteger;;

public abstract class PrimeCheck {
	public BigInteger number;
	
	public PrimeCheck(String number) {
		this.number = new BigInteger(number);
	}
	
	public abstract boolean check() {
		
	}

	public static void main(String[] args) {
		
		BigInteger i = new BigInteger("1000000000000000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println(i.add(new BigInteger("1")));
		
		//Prime p = PrimeCheck("137");
		//System.print(p.check())

	}

}
