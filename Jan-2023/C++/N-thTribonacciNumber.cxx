 // 1137. N-th Tribonacci Number

 // just add the last 3 variables

class Solution {

public:

    int tribonacci(int n) {

        if(n==0) return 0;

        if(n<=2) return 1;

        int a=0;

        int b=1;

        int c=1;

        int d=0;

        while(n--!=2){

            d=a+b+c;

            a=b;

            b=c;

            c=d;

            

        }

        return d;

    }

};
