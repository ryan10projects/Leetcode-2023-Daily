// 904. Fruit Into Baskets
class Solution {
    public int totalFruit(int[] fruits) {
        //first new fruit you will see
        int firstFruit=-1;
        //second new fruit you will see
        int secondFruit=-1;
        //keep track of the first new fruitb
        int lastCount=0;
        int currFruitCount=0;
        int max=0;
        for(int i=0; i<fruits.length;i++) 
          {
            //if we find any of the fruits in our basket,
            //we add them
            if(fruits[i]==firstFruit || fruits[i]==secondFruit){
                currFruitCount+=1;
                
            }
            else{
                //found new fruit, add the last fruit in basket since
                //you need to keep track count of the previous fruit too (2 different fruits)
                //adding 1 because you found the new fruit and + lastCount for adding all the previous fruit
                //imagine it like discarding the previous basket for a new one but keeping one of the two baskets you had
                currFruitCount=1+lastCount;
            }
            //you still have the first old fruit so count it so u can add it later if you find a new fruit
            if(fruits[i]==firstFruit){
                lastCount++;
              }
            else{
                //you found another new fruit so u reset it to 1 because you have 3 now
                //we need to find the maximum subarray between those two fruits so reset everything once you find the third fruit
                lastCount=1;
              }
              //we found a new fruit so we update firstfruit and secondfruit
            if(fruits[i]!=firstFruit){
              secondFruit=firstFruit;
              firstFruit=fruits[i];
            }
            
            max=Math.max(max,currFruitCount);
         }
        return max;
    }
}
