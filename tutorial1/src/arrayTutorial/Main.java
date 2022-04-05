package arrayTutorial;

public class Main {

	public static void main(String[] args) {
	//This Tutorial is for arrays
		
	//Remember arrays start at zero and to forward. so 0,1,2,3,4,5...
		
	// Create an  String based array called newArr with 5 slots
		//Currently this array is empty
		String[] newArr = new String[5];
		//This will fill it up
		newArr[0] = "Hello";
		newArr[1] = "Hi";
		newArr[2] = "Tim";
		newArr[3] = "Bill";
		newArr[4] = "Joe";
		
	// Integer Array - You can also fill up arrays like so
		int[] nums = {2,3,54,6,6};
		
	// Double Array - Same as the rest
		double[] nums2 = {2.0, 3.0};
		
		String x = newArr[1];
		System.out.println(x);
		
		int y = nums[2];
		System.out.println(y);
		
		double z = nums2[0];
		System.out.println(z);
		
	
		
 	}

}
