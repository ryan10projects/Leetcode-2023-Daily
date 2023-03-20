// 605. Can Place Flowers
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++){
            
            if((i==0 || flowerbed[i-1]==0) && flowerbed[i]==0 && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                n--;
                flowerbed[i]=1;
         }
            
     }
        return n<=0;
    }
}
