
// 2336. Smallest Number in Infinite Set
// keep a boolean array of all elements which exists or not, true if the exist and everytime you see a smallest element update the i index to that one so you can pop it later
class SmallestInfiniteSet {

	boolean[] arr;
	int i;
	public SmallestInfiniteSet() {
		arr = new boolean[1001];
		for (int j = 0; j < 1001; j++) {
			arr[j] = true;
		}
		i = 1;
	}
	public int popSmallest() {
		arr[i] = false;
		int num = i;

		for (int j = 1; j < 1001; j++) {
			if (arr[j] == true) {
				i = j;
				break;
			}
		}

		return num;
	}

	public void addBack(int num) {
		arr[num] = true;
		if (num < i) {
			i = num;
		}
	}
}
