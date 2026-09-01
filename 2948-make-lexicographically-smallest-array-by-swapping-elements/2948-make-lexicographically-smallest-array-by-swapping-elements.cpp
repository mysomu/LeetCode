class Solution {
public:
    vector<int>per;
    vector<int>sz;

    int find(int i)
    {
        if(per[i]==i)return i;
        return per[i]=find(per[i]);
    }

    void unite(int i,int j){
        int ui=find(i);
        int uj=find(j);

        if(ui==uj)return;

        if(sz[ui]>=sz[uj]){
            per[uj]=ui;
            sz[ui]+=sz[uj];
        }
        else{
            per[ui]=uj;
            sz[uj]+=sz[ui];
        }
    }

    vector<int> lexicographicallySmallestArray(vector<int>& nums,int limit) {
        int n=nums.size();

        per.resize(n);
        sz.resize(n,1);

        for(int i=0;i<n;i++)per[i]=i;

        vector<pair<int,int>>temp;

        for(int i=0;i<n;i++)
            temp.push_back({nums[i],i});

        sort(temp.begin(),temp.end());

        for(int i=0;i<n-1;i++){
            int x=temp[i].first;
            int xi=temp[i].second;

            int y=temp[i+1].first;
            int yi=temp[i+1].second;

            if(abs(x-y)<=limit){
                unite(xi,yi);
            }
        }

        unordered_map<int,vector<pair<int,int>>>mp;

        for(int i=0;i<n;i++){
            int p=find(i);
            mp[p].push_back({nums[i],i});
        }

        vector<int>ans=nums;

        for(auto&it:mp){
            vector<pair<int,int>>temp=it.second;

            vector<int>a;
            vector<int>b;

            for(int j=0;j<temp.size();j++){
                a.push_back(temp[j].first);
                b.push_back(temp[j].second);
            }

            sort(a.begin(),a.end());
            sort(b.begin(),b.end());

            for(int i=0;i<b.size();i++){
                ans[b[i]]=a[i];
            }
        }

        return ans;
    }
};