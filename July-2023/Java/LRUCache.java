class LRUCache {
public:
    list<int> ddl;
    int n;
    map<int,pair<list<int>::iterator,int>> map;
    
    LRUCache(int capacity) {
        n=capacity;
    }
    
    int get(int key) {
        if(map.find(key) == map.end()) return -1;
        
        ddl.erase(map[key].first);
        
        ddl.push_front(key);

        map[key].first=ddl.begin();
        
        return map[key].second;
            
    }
    
    void put(int key, int value) {
        if(map.find(key)!=map.end()){
            map[key].second=value;
            ddl.erase(map[key].first);
            ddl.push_front(key);
            map[key].first=ddl.begin();
           
        }
        else{
            ddl.push_front(key);
            map[key]={ddl.begin(),value};
           
            n--;
         }
        
        if(n<0){
            int k = ddl.back();
            map.erase(k);
            ddl.pop_back();
            n++;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
