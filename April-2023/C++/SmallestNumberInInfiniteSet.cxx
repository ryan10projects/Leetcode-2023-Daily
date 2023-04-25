
// 2336. Smallest Number in Infinite Set
// keep a boolean array of all elements which exists or not, true if the exist and everytime you see a smallest element update the i index to that one so you can pop it later

class SmallestInfiniteSet {
    bool arr[1001];
    int i;

public:
    SmallestInfiniteSet() {
        for(int j=0; j<1001; j++){
            arr[j] = true;
        }
        i=1;
    }

    int popSmallest() {
        arr[i] = false;
        int num = i;

        for(int j=i+1; j<1001; j++){
            if(arr[j] == true){
                i = j;
                break;
            }
        }

        return num;
    }

    void addBack(int num) {
        arr[num] = true;
        if(num < i){
            i = num;
        }
    }
};
