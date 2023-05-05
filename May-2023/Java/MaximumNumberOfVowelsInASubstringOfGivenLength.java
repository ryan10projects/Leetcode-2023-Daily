class Solution {
    
public int maxVowels(String s, int k) {
	Set<Character> set = new HashSet<>();
	set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
	int[] count = new int[26]; //character count
	int max = 0, currentVowels = 0;
	for (int right = 0; right < s.length(); right++) {
		if(set.contains(s.charAt(right)))  currentVowels++; 
		if(right >= k && set.contains(s.charAt(right - k))) currentVowels--;
		max = Math.max(currentVowels, max);
	}
	return max;
}
}
