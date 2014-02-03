import java.math.BigInteger;


public class RSA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BigInteger n = BigInteger.valueOf(0);
		BigInteger e = BigInteger.valueOf(0);
		BigInteger d = BigInteger.valueOf(0);
		
		// min = 2^1000
		BigInteger min = BigInteger.valueOf(2);
		min = min.pow(1000);
		
		FabriqueCle fabrique = new FabriqueCle(n, e, d, min);
		
		fabrique.getPublicPrivateKey();
		
		System.out.println("Min = "+fabrique.getMin());
		
		System.out.println("Clé publique (n |||| e) = ("+fabrique.getN()+" |||| "+fabrique.getE()+")");
		
		System.out.println("Clé privée d = "+fabrique.getD());
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
