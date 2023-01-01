
//290. Word Pattern

class Solution {
	public boolean wordPattern(String pattern, String s) {
		//Using a HashMap for mapping each word to a character in pattern
		HashMap<String, Character> map = new HashMap<>();
		//Converting the string of words into an array 
		String[] array = s.split(" ");
		if (array.length != pattern.length()) return false;
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(array[i])) {
				//comparing if the character in pattern is same as the value in the HashMap
				if (pattern.charAt(i) != map.get(array[i])) {
					System.out.println(array[i]);
					return false;
				}
			}
			else {
				if (map.containsValue(pattern.charAt(i))) return false;
				map.put(array[i], pattern.charAt(i));
			}
		}
		return true;
	}
}
