class Trie {
    Trie[] t;
    boolean isEnd;
    public Trie() {
        t=new Trie[26];
        isEnd=false;
        for(int i=0;i<26;i++)
            t[i]=null;
    }
    
    public void insert(String word) {
        Trie r=this;
        for(char c:word.toCharArray())
        {
            if(r.t[c-'a']==null)
                r.t[c-'a']=new Trie();
            r=r.t[c-'a'];
        }
        r.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie r=this;
        for(char c:word.toCharArray())
        {
            if(r.t[c-'a']==null)
                return false;
            r=r.t[c-'a'];
        }
        return r.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie r=this;
        for(char c:prefix.toCharArray())
        {
            if(r.t[c-'a']==null)
                return false;
            r=r.t[c-'a'];
        }
        return true;
    }
}