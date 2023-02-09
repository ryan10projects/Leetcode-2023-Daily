// 2306. Naming a Company
/*Algorithm
HashSet for better memory searching.
26 times to not look for the same character twice in case of duplicates.
multiplying both unique group of elements at the end for unique pairs for each character, we will not add here.
*/
class Solution {
    public long distinctNames(String[] ideas) {
        long res=0;
        HashMap<Character, HashSet<String>> map = new HashMap<>();
        for(char i='a'; i<='z'; i++){
            map.put(i, new HashSet<>());
        }
        for(String s: ideas){
            map.get(s.charAt(0)).add(s.substring(1,s.length()));
        }

        for(int i=0; i<25; i++){
            for(int j=i+1; j<26; j++){
                long not_common_1_group=0;
                long not_common_2_group=0;
                HashSet<String> set1 = map.get((char)(i + 'a'));
                HashSet<String> set2 = map.get((char)(j + 'a'));
                for(String c: set1){
                    if(!set2.contains(c)){
                        not_common_1_group++;
                    }
                }
                for(String c: set2){
                    if(!set1.contains(c)){
                        not_common_2_group++;
                    }
                }

                res += not_common_1_group * not_common_2_group;
            }
        }

        return 2 * res;
    }
}
