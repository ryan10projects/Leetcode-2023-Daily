// 649. Dota2 Senate
// Algorithm
// delete immediate right
// use indx+1/n to look for elements to the left of array (rotation)
// if Dire, call delete function and delete rightmost charactet and vice versa otherwise
// keep track of count, if anyone reaches 0 first, the other party wins
class Solution {
	int n;

	public void deletion(String senate, boolean[] deleted, char ch, int indx) {

		while (true) {
			if (senate.charAt(indx) == ch && deleted[indx] == false) {
				deleted[indx] = true;
				break;
			}
			indx = (indx + 1) % n;
		}
	}

	public String predictPartyVictory(String senate) {
		boolean[] deleted = new boolean[senate.length()];

		n = senate.length();

		int R_count = 0;
		int D_count = 0;

		for (char c : senate.toCharArray()) {
			if (c == 'R') R_count++;
		}

		int indx = 0;

		D_count = n - R_count;

		while (R_count > 0 && D_count > 0) {
			if (deleted[indx] == false) {
				if (senate.charAt(indx) == 'R') {
					deletion(senate, deleted, 'D', (indx + 1) % n);
					D_count--;
				} else {
					deletion(senate, deleted, 'R', (indx + 1) % n);
					R_count--;
				}

			}
			indx = (indx + 1) % n; //allows rotation

		}
		return R_count == 0 ? "Dire" : "Radiant";
	}
}
