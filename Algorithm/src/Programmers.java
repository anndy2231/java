import java.util.Arrays;

public class Programmers {

	public static void main(String[] args) {

		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int[] copy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(copy);
			answer[i] = copy[commands[i][2]-1];
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
