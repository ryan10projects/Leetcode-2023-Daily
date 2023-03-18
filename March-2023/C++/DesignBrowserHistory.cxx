// 1472. Design Browser History
class BrowserHistory {
public:
    // backs stack will act as the back history
    // forwards stack will act as the forward history
    stack<string> backs;
    stack<string> forwards;
    BrowserHistory(string homepage) {
        backs.push(homepage);
    }
    
    void visit(string url) {
        while(!forwards.empty()){
           forwards.pop();
        }
        backs.push(url);
    }
    
    string back(int steps) {
        string res="";
        while(steps-- && backs.size()>1){
            forwards.push(backs.top());
            backs.pop();
        }
        res = backs.top();
        return res;
    }
    
    string forward(int steps) {
        string res="";
        while(steps-- && !forwards.empty())
        {
            backs.push(forwards.top());
            forwards.pop();
        }
        res = backs.top();
        return res;
    }
};

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */
