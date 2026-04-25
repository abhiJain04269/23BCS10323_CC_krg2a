#include <bits/stdc++.h>
using namespace std;

vector<int> buildLPS(string pattern) {
    int m = pattern.size();
    vector<int> lps(m, 0);

    int len = 0; 
    int i = 1;

    while (i < m) {
        if (pattern[i] == pattern[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

vector<int> kmpSearch(string text, string pattern) {
    vector<int> lps = buildLPS(pattern);
    vector<int> result;

    int i = 0;
    int j = 0; 

    while (i < text.size()) {
        if (text[i] == pattern[j]) {
            i++;
            j++;
        }

        
        if (j == pattern.size()) {
            result.push_back(i - j);
            j = lps[j - 1]; 
        }
    
        else if (i < text.size() && text[i] != pattern[j]) {
            if (j != 0) {
                j = lps[j - 1]; 
            } else {
                i++;
            }
        }
    }

    return result;
}

// Driver code
int main() {
    string text, pattern;

    cout << "Enter text: ";
    cin >> text;

    cout << "Enter pattern: ";
    cin >> pattern;

    vector<int> matches = kmpSearch(text, pattern);

    if (matches.empty()) {
        cout << "No match found\n";
    } else {
        cout << "Pattern found at indices: ";
        for (int idx : matches) {
            cout << idx << " ";
        }
        cout << endl;
    }

    return 0;
}