// Optimal Partition of String

// hash set to keep track of distinct elements
class Solution {

    public int partitionString(String s) {

        Set<Character> set = new HashSet<>();

        int count = 1;

        

        for(int i=0; i<s.length(); i++){

            if(set.contains(s.charAt(i)))

            {

                count++;

                set.clear();

                set.add(s.charAt(i));

                    

             }

            else{

                set.add(s.charAt(i));

               

            }

                

                

            

        }

        return count;

    }

}
