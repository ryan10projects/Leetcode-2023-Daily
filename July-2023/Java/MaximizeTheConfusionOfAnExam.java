// 2024. Maximize the Confusion of an Exam
// Algorithm
// use hashmap to store count
// compare the count, and pick the minimum one
// if the minimum one is > k, remove the leftmost count
// otherwise get the length of the window by j-i+1
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int answer = 0;
        int i=0, j=0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<answerKey.length()){
            map.put(answerKey.charAt(j),map.getOrDefault(answerKey.charAt(j),0)+1);
            if(map.containsKey('T') && map.containsKey('F')){
                while(Math.min(map.get('T'),map.get('F'))>k){
                    map.put(answerKey.charAt(i),map.getOrDefault(answerKey.charAt(i),0)-1);
                    i++;
               }
            }
            answer = Math.max(j-i+1,answer);
            j++;
        }
        return answer;
    }
}
