

// 460. LFU Cache
class LFUCache {

    int min=1;

        HashMap<Integer,Integer> keyvalue = new HashMap<>();
        HashMap<Integer,Integer> keyfreq = new HashMap<>();
        HashMap<Integer, LinkedHashSet<Integer>> freqlist = new HashMap<>();
    int n=0;
        public LFUCache(int capacity){
         n = capacity;
        freqlist.put(1,new LinkedHashSet<>());
    }
    
    public int get(int key) { 
        //Check if it exists in the keyvalue map, if not return -1;
        // return the value if it exists
        if(!keyvalue.containsKey(key)){
            return -1;
         }
   
        //We need to update the frequency after every get and put
        //Get the Freq and remove it from keylist since we are using new frequency for the key now
        int freq = keyfreq.get(key);
        freqlist.get(freq).remove(key);
        //Check if its the lowest frequency by checking if the minimum frequency is 1 as well (for first iteration) and
        //check if the LinkedSet is empty, if it is we need to go the next lowest frequency 
        if(freq==min && freqlist.get(freq).size()==0){
            min++;
         }
        // Since we need to add the Freq+1 for every put and get, we add it inside LinkedHashSet and keyfreq
        if(!freqlist.containsKey(freq+1)){
            freqlist.put(freq+1,new LinkedHashSet<>());
            }
        freqlist.get(freq+1).add(key);
        keyfreq.put(key,freq+1);
        return keyvalue.get(key); 
    }
    
   public void put(int key, int value) {
        //No place to add anything so return
        if(n<=0) return;
        //Add the updated value if it exists and return
       // Since we did a put we need to update the Freq so call get again 
        if(keyvalue.containsKey(key)){
            keyvalue.put(key,value);
           get(key);
            return;
         }
        //Reached the limit so remove everything from all 3 hashset since we will never use it
        //Remove only the least frequency one
        if(keyvalue.size()>=n){
            int k = freqlist.get(min).iterator().next();
            keyvalue.remove(k);
            keyfreq.remove(k);
            freqlist.get(min).remove(k);
            
        }
        //We never saw the new value so we just add it normally
        keyvalue.put(key,value);
        keyfreq.put(key,1);
        freqlist.get(1).add(key);
        //Since it's a new value, minimum Freq is updated to 1
        min=1;
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache* obj = new LFUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
