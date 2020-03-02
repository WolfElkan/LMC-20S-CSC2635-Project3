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
			c = shift('0','9',c,key);
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
	private int key;
	public ShuffleCipher(int key) {
		this.key = key;
	}
	private String encodeIteration(String plaintext, int pivot) {
		String left = plaintext.substring(0,pivot);
		String right = plaintext.substring(pivot);
		String result = "";
		int shorter = left.length()<right.length()?left.length():right.length();
		for (int i=0; i<shorter; i++) {
			result += right.substring(0,1);
			right  =  right.substring(1);
			result += left.substring(0,1);
			left   =  left.substring(1);
		}
		return result;
	}
	public String encode(String plaintext) {
		String result = plaintext;
		for (int i = 0; i < key; i++) {
			int pivot = result.length() / 2;
			if (result.length() % 2 == 1 && i % 2 == 1) {
				pivot += 1;
			}
			result = encodeIteration(result, pivot);
		}
		return result;
	}
	public String decode(String ciphertext) {
		return "";
	}
}

class Project3 {
	public static void main(String[] args) {
		ShuffleCipher cipher = new ShuffleCipher(1);
		System.out.println(cipher.encode("abcdefghijklmnopqrstuvwxyz"));
	}
}