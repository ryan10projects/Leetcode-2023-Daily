// 67. Add Binary
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder res = new StringBuilder();
        int sum=0;
        int carry=0;
        while(i>=0 && j>=0){
            sum=carry;
            int digit = a.charAt(i)-'0';
            int digit2 = b.charAt(j)-'0';
            sum+=digit+digit2;
            //if 1+1=2 then 2%2=0
            //then carry = 2/2=1
            //there is a carry in this case
            //save the carry under carry variable so in the 
            //next iteration you can add it to sum
            //3%2=1 and 3/2=1
            res.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        //Add remaining numbers
        while(i>=0){
            sum=carry;
            int digit = a.charAt(i)-'0';
            sum+=digit;
            res.append(sum%2);
            carry=sum/2;
            i--;
        }
        //Add remaining numbers
        while(j>=0){
            sum=carry;
            int digit = b.charAt(j)-'0';
            sum+=digit;
            res.append(sum%2);
            carry=sum/2;
            j--;
            }
        //If carry is remaining add 1
        if(carry==1){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
