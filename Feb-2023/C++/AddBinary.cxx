// 67. Add Binary
class Solution {

	public:

	string addBinary(string a, string b) {

		int i = a.length() - 1;

		int j = b.length() - 1;

		string res = "";

		int sum = 0;

		int carry = 0;

		while (i >= 0 && j >= 0) {

			sum = carry;

			int digit = a[i] - '0';

			int digit2 = b[j] - '0';

			sum += digit + digit2;
			
			//if 1+1=2 then 2%2=0
            //then carry = 2/2=1
            //there is a carry in this case
            //save the carry under carry variable so in the
            //next iteration you can add it to sum
            //3%2=1 and 3/2=1
			res = to_string(sum % 2) + res;

			carry = sum / 2;

			i--;

			j--;

		}
        //add remaining numbers
		while (i >= 0) {

			sum = carry;

			int digit = a[i] - '0';

			sum += digit;

			res = to_string(sum % 2) + res;

			carry = sum / 2;

			i--;

		}

        //add remaining numbers
		while (j >= 0) {

			sum = carry;

			int digit = b[j] - '0';

			sum += digit;

			res = to_string(sum % 2) + res;

			carry = sum / 2;

			j--;

		}
		
		//final carry at front

		if (carry == 1) {

			res = "1" + res;

		}

		return res;

	}

};
