class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList();
        if(digits.length()==0) return res;
        HashMap<Character,String> map = new HashMap<>();

        map.put('2',"abc");

        map.put('3',"def");

        map.put('4',"ghi");

        map.put('5',"jkl");

        map.put('6',"mno");

        map.put('7',"pqrs");

        map.put('8',"tuv");

        map.put('9',"wxyz");
        
        backtrack(digits,map,0,res, new StringBuilder());
        return res;
    }
    
    public void backtrack(String digits, HashMap<Character,String> map, int index, List<String> res,StringBuilder sb){
       
        if(index==digits.length()){
            res.add(sb.toString());
            return;
            }
        String curr = map.get(digits.charAt(index));
        for(int i=0;i<curr.length();i++){
            sb.append(curr.charAt(i));
            backtrack(digits,map,index+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
            }
        }
}
