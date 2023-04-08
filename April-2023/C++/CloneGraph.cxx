
class Solution {
public:
    Node* cloneGraph(Node* node) {
        if(node==nullptr) return nullptr;
        unordered_map<Node*,Node*> map;
        return dfs(map,node);
    }
    
    Node* dfs(unordered_map<Node*,Node*>& map, Node* n){
        if(map.count(n)) return map[n];
        Node* copy = new Node(n->val);
        map[n] = copy;
        for(Node* nei : n->neighbors){
            copy->neighbors.push_back(dfs(map,nei));
        }
        return copy;
    }
};
