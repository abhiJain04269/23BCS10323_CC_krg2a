#include <iostream>
using namespace std;

int minimumSize(vector<int>& nums, int op) {
    
    int maxs = 0;
    unordered_map<int, int> mp;

    for (int n : nums) {
        mp[n]++;
        maxs = max(maxs, n);
    }

    int lo = 1, hi = maxs;

    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;

        long long split = 0;

        for (auto &entry : mp) {
            int s = entry.first;
            int cnt = entry.second;

            if (s <= mid) continue;

            split += (long long)cnt * ((s + mid - 1) / mid - 1);
        }

        if (split > op)
            lo = mid + 1;
        else
            hi = mid;
    }

    return lo;
}

int main() {
    vector<int> a = {9};
    int r = minimumSize(a, 2);
    cout<<r<<endl;
}

