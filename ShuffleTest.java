class ShuffleTest {
	public int index = 0;
	public int width = 8;
	public void count() {
		String number = Integer.toString(index++);
		while (number.length() < width) {
			number = " " + number;
		}
		System.out.print(number);
		System.out.print(' ');
	}
	public void allPermutations(String input, String prefix) {
		if (input.length()==2) {

			count();
			System.out.print(prefix);
			System.out.print(input.substring(0,1));
			System.out.print(input.substring(1,2));
			System.out.println();

			count();
			System.out.print(prefix);
			System.out.print(input.substring(1,2));
			System.out.print(input.substring(0,1));
			System.out.println();
		} else {
			for (int i=0; i<input.length(); i++) {
				String moveToFront = input.substring(i,i+1);
				String allElse = input.substring(0,i) + input.substring(i+1);

				allPermutations(allElse, prefix+moveToFront);
			}
		}
	}
	public void allPermutations(String input) {
		allPermutations(input,"");
	}
	public static void main(String[] args) {
		ShuffleTest me = new ShuffleTest();
		int n = 4; // Change this variable to test different lengths
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		me.allPermutations(alphabet.substring(0,n));
	}
}