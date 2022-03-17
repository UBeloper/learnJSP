import java.util.ArrayList;

public class Generic {

	public static void main(String[] args) {
		ArrayList<Integer> lists = new ArrayList<Integer>();
		int[] array = {1, 2, 3, 4, 5};
		
		lists.add(1);
		lists.add(1);
		lists.add(1);
		
		int sum = 0;
		for(Integer list : lists) {
			sum += list;
			System.out.println(sum);
		}
		
		String str = new String("HI");
		System.out.println(str.toString());
		
		
		
	}

}
