import java.math.BigInteger;
import java.util.Random;


public class FabriqueCle {
	
	// ------------------------------ //
	// ---------- Attributs --------- //
	// ------------------------------ //
	
	BigInteger n;
	BigInteger e;
	BigInteger d;
	BigInteger min;
	
	// ------------------------------- //
	// -------- Constructeur --------- //
	// ------------------------------- //
	
	public FabriqueCle(BigInteger n, BigInteger e, BigInteger d, BigInteger min) {
		this.n = n;
		this.e = e;
		this.d = d;
		this.min = min;
	}
	
	// --------------------------------- //
	// ------ Fonction Principale ------ //
	// --------------------------------- //
	
	public void getPublicPrivateKey() {
		
		BigInteger p = this.min;
		BigInteger q = BigInteger.valueOf(0);
		BigInteger w = BigInteger.valueOf(0);
		
		Random rand = new Random();
		
		while (! p.isProbablePrime(14)) {
			p = p.nextProbablePrime();
		}
		
		q = p.nextProbablePrime();
		
		while (! q.isProbablePrime(14)) {
			q = q.nextProbablePrime();
		}
		
		// n = p*q
		this.n = p.multiply(q);
		
		// w = (p-1)*(q-1)
		w = (p.subtract(BigInteger.valueOf(1))).multiply((q.subtract(BigInteger.valueOf(1))));
	
		this.d = BigInteger.valueOf(rand.nextInt()).mod(w);
	
		// tant que pgcd(d, w) != 1
		while (! this.d.gcd(w).equals(BigInteger.ONE)) {
			rand.nextInt();
			this.d = BigInteger.valueOf(rand.nextInt()).mod(w);
		}
		
		// e = 1/d
		this.e = this.d.modInverse(w);
			
	}
	
	// ------------------------------- //
	// ------ Getters & Setters ------ //
	// ------------------------------- //

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public BigInteger getMin() {
		return min;
	}

	public void setMin(BigInteger min) {
		this.min = min;
	}
	

}
