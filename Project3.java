// import java.util.*;

interface MessageEncoder {
	String encode(String plaintext);
}

interface MessageDecoder {
	String decode(String ciphertext);
}

class SubstitutionCipher implements MessageEncoder, MessageDecoder {
	private int key;
	public SubstitutionCipher(int key) {
		this.key = key;
	}
	private char shift(char a, char z, char letter, int key) {
		if (a <= letter && letter <= z) {
			letter -= a;
			letter += key;
			letter += z - a;
			letter %= z - a;
			letter += a;
		}
		return (char)letter;
	}
	private String shift(String text, int key) {
		String result = "";
		for (int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			c = shift('A','Z',c,key);
			c = shift('a','z',c,key);
			result += c;
		}
		return result;
	}
	public String encode(String plaintext) {
		return shift(plaintext,key);
	}
	public String decode(String ciphertext) {
		return shift(ciphertext,-key);
	}
}

class ShuffleCipher implements MessageEncoder, MessageDecoder {
	public String encode(String plaintext) {
		return "";
	}
	public String decode(String ciphertext) {
		return "";
	}
}

class Project3 {
	public static void main(String[] args) {
		SubstitutionCipher cipher = new SubstitutionCipher(7);
		System.out.println(cipher.decode("Olssv evysk!"));
	}
}