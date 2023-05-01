// 1491. Average Salary Excluding the Minimum and Maximum Salary
// n*log(n)
class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);     
        double sum=0;        
        for(int i=1; i<salary.length-1; i++){
            sum+=salary[i];           
       }
         return sum/(salary.length-2);
    }
}

// o(n)
class Solution {
public:
    double average(vector<int>& salary) {
       double total = 0;
       int mn = INT_MAX,mx = INT_MIN;
       for(int i=0;i<salary.size();i++){
            mn = min(mn,salary[i]);
            mx = max(mx,salary[i]);
            total+=salary[i];
       }
       return (total - mn - mx)/(salary.size()-2);
    }
};
