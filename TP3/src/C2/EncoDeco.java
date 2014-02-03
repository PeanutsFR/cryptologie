package C2;

import java.math.BigInteger;

public class EncoDeco {
	
	// ------------------------------ //
	// ---------- Attributs --------- //
	// ------------------------------ //
	
	String message; // message m
	BigInteger M; // entier M
	
	// ------------------------------- //
	// -------- Constructeur --------- //
	// ------------------------------- //

	public EncoDeco(String message, BigInteger M) {
		super();
		this.message = message;
		this.M = M;
	}
	
	// --------------------------------- //
	// ----- Fonctions Principales ----- //
	// --------------------------------- //

	/**
	 * Traduit le message m en entier M
	 */
	public void chaine2BigInt() {
		
		// taille du message
		int l = this.message.length();
		
		// nombre temporaire pour clarifier le calcul de la somme
		int puiss = 0;
		
		// on initialise la valeur de M à 0
		this.M = BigInteger.ZERO;
		
		// M = somme (Ci * 256^i)
		for (int i=0; i<l; i++) {
			puiss = (int) Math.pow(256, i);
			this.M = this.M.add(BigInteger.valueOf(Character.getNumericValue(this.message.charAt(i)) * puiss));
		}
	}
	
	/**
	 * Calcule la chaîne de caractères qui correspond à un entier donné
	 */
	public void bigInt2chaine() {
		
		// nombre tempo pour aider au calcul
		BigInteger D = M;
		BigInteger Q = BigInteger.ZERO;
		BigInteger R = BigInteger.ZERO;
		
		// tant que D >= Q
		while ((D.compareTo(BigInteger.valueOf(256)) == 1) || (D.compareTo(BigInteger.valueOf(256)) == 0)) {
			Q = D.divide(BigInteger.valueOf(256));
			R = D.mod(BigInteger.valueOf(256));
			this.message += (char) R.toByteArray()[1];
			D = Q;
		}
		
	}
	
	
	
	// ------------------------------- //
	// ------ Getters & Setters ------ //
	// ------------------------------- //

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BigInteger getM() {
		return M;
	}
	public void setM(BigInteger M) {
		this.M = M;
	}
	

}
