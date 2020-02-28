interface MessageEncoder {
	String encode(String plaintext, int key);
}

interface MessageDecoder {
	String decode(String ciphertext, int key);
}

class SubstitutionCipher implements MessageEncoder, MessageDecoder {
	public String encode(String plaintext, int key) {
		return "";
	}
	public String decode(String ciphertext, int key) {
		return "";
	}
}

class ShuffleCipher implements MessageEncoder, MessageDecoder {
	public String encode(String plaintext, int key) {
		return "";
	}
	public String decode(String ciphertext, int key) {
		return "";
	}
}

class Project3 {
	public static void main(String[] args) {
		
	}
}