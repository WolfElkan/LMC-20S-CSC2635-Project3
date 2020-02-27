interface MessageEncoder {
	String encode();
}

interface MessageDecoder {
	String decode();
}

class SubstitutionCipher implements MessageEncoder, MessageDecoder {
	public String encode(String plaintext) {
		return "";
	}
	public String decode(String ciphertext) {
		return "";
	}
}

class Project3 {
	public static void main(String[] args) {
		
	}
}