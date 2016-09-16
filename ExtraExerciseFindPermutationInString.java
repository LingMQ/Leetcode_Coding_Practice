import java.util.*;

public class ExtraExerciseFindPermutationInString{
	
	public static void main(String[] args){
		String s = "abbc";
		String b = "cbabadcbbabbcbabaabccbabc";
		Vector<Integer> tmp = findAllPermutation(s, b);
		System.out.println(Arrays.toString(tmp.toArray()));
	}

	public static boolean equal(int[] orig, int[] tmp){
		for (int i = 0; i < orig.length; i++) {
			if(orig[i] != tmp[i])
				return false;
		}
		return true;
	}

	public static Vector<Integer> findAllPermutation(String s, String b){
		// check the capitalized cases
		// s, b length 
		int[] orig = new int[26];
		int[] tmp = new int[26];
		for (int i = 0; i < s.length(); i++) {
			orig[s.charAt(i) - 'a']++;
			tmp[b.charAt(i) - 'a']++;
		}
		System.out.println(Arrays.toString(orig));
		Vector<Integer> allPermutationIndex = new Vector<Integer>();
		if(equal(orig, tmp)){
			allPermutationIndex.addElement(new Integer(0));
		}

		for (int i = s.length(); i < b.length() - (s.length() - 1); i++) {
			/*if(orig[b.charAt(i) - 'a'] == 0){
				tmp = new int[26];
				i += s.length();
				System.out.println(i);
			}else{*/
				// check the index -1
				if(tmp[b.charAt(i - s.length()) - 'a'] > 0){
					tmp[b.charAt(i - s.length()) - 'a']--;
				}
				tmp[b.charAt(i) - 'a']++;
				System.out.println(Arrays.toString(tmp));
				if(equal(orig, tmp))
					allPermutationIndex.addElement(new Integer(i - s.length() + 1));
			//}
		}
		return allPermutationIndex;
	}
}
