#include <iostream>
using namespace std;

int maxSum(vector<int>& nums, int k) {

    long long MOD = 1000000007;

    vector<int> bitCount(32, 0);

    for (int num : nums) {
        for (int b = 0; b < 32; b++) {
            if ((num & (1 << b)) != 0) {
                bitCount[b]++;
            }
        }
    }

    long long ans = 0;

    for (int i = 0; i < k; i++) {

        long long val = 0;

        for (int b = 0; b < 32; b++) {
            if (bitCount[b] > 0) {
                val |= (1LL << b);
                bitCount[b]--;
            }
        }
 
        ans = (ans + (val * val) % MOD) % MOD;
    }

    return (int)ans;
}

int main() {
    vector<int> a = {2, 6, 5, 8};
    int r = maxSum(a, 3);
    cout << r << endl;
}