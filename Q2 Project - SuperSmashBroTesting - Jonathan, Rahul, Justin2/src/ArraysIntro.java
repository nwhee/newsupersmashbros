
public class ArraysIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int x = 0;
		
		int[] scores = new int[10];
		
		System.out.println(scores.length);
		
		System.out.println(scores[scores.length - 1]);
		
		
		scores[0] = 7;
		System.out.println(scores[0]);
		
		
		int[] randomness = new int[31];
		
		for(int i = 0; i < randomness.length; i++) {
			randomness[i] = i;
			
		}
		for(int i = 0; i < randomness.length; i++) {
			System.out.println(randomness[i]);
		}
		
	}

}
