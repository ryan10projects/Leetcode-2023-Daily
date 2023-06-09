// 744. Find Smallest Letter Greater Than Target
class Solution {
    public int binarysearch(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int idx = binarysearch(letters, target);
        if (idx == letters.length) {
            return letters[0];
        }
        return letters[idx];
    }
}
