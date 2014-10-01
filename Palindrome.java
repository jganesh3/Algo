
/*
 * @ author Ganesh Joshi
 * 
 * Check if the given string contain any palindrome.
 * Longest Palindrome Search using Manacher's Algorithm
 */
public class Palindrome {

	public static boolean isPailndrome(String s) {

		int len = s.length() - 1;

		boolean flag = true;
		for (int i = 0, j = len; i < j; i++, j--) {
			if (s.charAt(i) == ' ')
				i++;
			if (s.charAt(j) == ' ')
				j--;
			if (s.toLowerCase().charAt(i) == s.toLowerCase().charAt(j))
				continue;
			else {
				flag = false;
			}

		}
		return flag;

	}

	/*
	 * Longest Palindrome Search using Manacher's Algorithm
	 */

	public static String preProcess(String data) {

		int i, k;

		// transform array will store converted string data with # character's
		char[] transform = new char[data.length() * 2 + 1];

		// p[i] = length of longest palindromic substring of t centered at i
		int[] p = new int[transform.length];

		if (data.length() == 0)
			return data;

		/*
		 * Step 1 Transform the given string into new String by putting # in
		 * between chracters.
		 */
		for (i = 0, k = 0; i < data.length() - 1; i++, k = k + 2) {
			// mString.append(data.charAt(i)+"#");
			transform[k] = '#';
			transform[k + 1] = data.charAt(i);
			;

		}
		transform[k] = '#';
		transform[k + 1] = data.charAt(i);
		transform[k + 2] = '#';
		/*
		 * End of the Step 1
		 */

		p[0] = 0;
		// p[transform.length*2+2]=0;

		for (int j = 1; j < transform.length - 1; j++) {

			int left = j - 1;
			int right = j + 1;
			while (left >= 0 && right < transform.length) {
				if (transform[right] == transform[left]) {
					p[j]++;
					left--;
					right++;
				} else
					break;
			}

		}

		System.out.println(transform);
		for (int j = 0; j < p.length; j++) {
			System.out.print(p[j] + " ");
		}

		// Print the palindrome
		//p[] will maintain the length of palindrome
		//p[] index will store the center of the palindrome
		int length = 0; 
		int center = 0; 
		for (int d = 0; d < p.length - 1; d++) {
			if (p[d] > length) {
				length = p[d];
				center = d;
			}
		}

		String toreturn = data.substring((center - length) / 2,
				(center + length) / 2);
		return toreturn;

	}

	public static void main(String[] args) {
		String p = "forgeeksskeegfor";
		System.out.println(preProcess(p));

	}

}
