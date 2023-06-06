// // 1502. Can Make Arithmetic Progression From Sequence
class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int diff = 0;
        bool isSet = false;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (!isSet) {
                diff = abs(arr[i] - arr[i + 1]);
                isSet = true;
            }
            
            if (isSet) {
                if (diff != abs(arr[i] - arr[i + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
};
