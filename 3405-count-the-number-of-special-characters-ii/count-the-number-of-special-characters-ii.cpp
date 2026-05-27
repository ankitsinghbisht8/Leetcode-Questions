class Solution {
public:
    int numberOfSpecialChars(string word) {
        unordered_map<char,int>umap;
        int n=word.size();
        for(int i=0;i<n;i++){
            if(isupper(word[i]) && umap.find(word[i])==umap.end()){
                umap[word[i]]=i;
            }
            if(islower(word[i])){
                umap[word[i]]=i;
            }
        }
        for(auto ele:umap){
            cout<<ele.first<<" "<<ele.second<<endl;
        }
        int count=0;
        for(char c='a';c<='z';c++){
            if(umap.find(c)!=umap.end() && umap.find(c-'a'+'A')!=umap.end()){
            if(umap[c]<umap[c-'a'+'A']){
                count++;
            }
            }
        }
        return count;
    }
};