// 1472. Design Browser History
class BrowserHistory {
    // backs stack will act as the back history
    // forwards stack will act as the forward history
    Stack<String> backs;
    Stack<String> forwards;

    public BrowserHistory(String homepage) {
        backs = new Stack<>();
        forwards = new Stack<>();
        backs.push(homepage);
    }

    public void visit(String url) {
        while (!forwards.empty()) {
            forwards.pop();
        }
        backs.push(url);
    }

    public String back(int steps) {
        String res = "";
        while (steps-- > 0 && backs.size() > 1) {
            forwards.push(backs.peek());
            backs.pop();
        }
        res = backs.peek();
        return res;
    }

    public String forward(int steps) {
        String res = "";
        while (steps-- > 0 && !forwards.empty()) {
            backs.push(forwards.peek());
            forwards.pop();
        }
        res = backs.peek();
        return res;
    }
}
