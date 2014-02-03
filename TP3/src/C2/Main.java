package C2;

import java.math.BigInteger;

public class Main {

	/**
	 * Main
	 */
	public static void main(String[] args) {
		
		String message = "Alfred";
		BigInteger M = BigInteger.ZERO;
		
		EncoDeco ed = new EncoDeco(message, M);
		
		ed.chaine2BigInt();
		
		System.out.println("--- Chaine2BigInt ---\n");
		System.out.println("chaine : "+ed.getMessage());
		System.out.println("M :"+ed.getM()+"\n");
		
		
		// ------------------------------------------------ //
		
		message = "";
		// 2601456879 = alfred
		M = new BigInteger("2601456879", 10);
		
		ed = new EncoDeco(message, M);
		
		System.out.println("--- bigInt2Chaine ---\n");
		System.out.println("M :"+ed.getM()+"\n");
		System.out.println("chaine : "+ed.getMessage());


	}

}
