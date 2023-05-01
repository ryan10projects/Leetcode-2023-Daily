// 1491. Average Salary Excluding the Minimum and Maximum Salary
// n*log(n)
#include <algorithm>
using namespace std;

class Solution {
public:
double average(vector<int>& salary) {
sort(salary.begin(), salary.end());
double sum = 0;
for(int i = 1; i < salary.size() - 1; i++){
sum += salary[i];
}
return sum / (salary.size() - 2);
}
};

// o(n)
#include <vector>
#include <climits>

class Solution {
public:
double average(vector<int>& salary) {
double total = 0;
int mn = INT_MAX, mx = INT_MIN;
for(int i = 0; i < salary.size(); i++){
mn = min(mn, salary[i]);
mx = max(mx, salary[i]);
total += salary[i];
}
return (total - mn - mx) / (salary.size() - 2);
}
};
