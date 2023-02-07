// 904. Fruit Into Baskets
class Solution {
	public:
	int totalFruit(vector<int> & fruits) {
		 //first new fruit you will see
		int firstBasket = -1;
		//second new fruit you will see
		int secondBasket = -1;
		 //keep track of the first new fruitb
		int firstBasketCount = 0;
		int maximum = 0;
		int totalCurrent = 0;
		for (int i = 0; i < fruits.size(); i++) {
			//if we find any of the fruits in our basket,
            //we add them
			if (fruits[i] == firstBasket || fruits[i] == secondBasket) {
				totalCurrent += 1;
			} else {
				//found new fruit, add the last fruit in basket since
                //you need to keep track count of the previous fruit too (2 different fruits)
                //adding 1 because you found the new fruit and + lastCount for adding all the previous fruit
                //imagine it like discarding the previous basket for a new one but keeping one of the two baskets you had
				totalCurrent = firstBasketCount + 1;
			}
l
			if (fruits[i] == firstBasket) {
				//you still have the first old fruit so count it so u can add it later if you find a new fruit
				firstBasketCount++;
			} else {
				 //you found another new fruit so u reset it to 1 because you have 3 now
                //we need to find the maximum subarray between those two fruits so reset everything once you find the third fruit
				firstBasketCount = 1;
			}

			if (fruits[i] != firstBasket) {
				 //we found a new fruit so we update firstfruit and secondfruit
				secondBasket = firstBasket;
				firstBasket = fruits[i];
			}

			maximum = max(maximum, totalCurrent);

		}
		return maximum;

	}
};
