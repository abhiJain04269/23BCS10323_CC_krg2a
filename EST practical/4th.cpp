#include <bits/stdc++.h>
using namespace std;

void dfs(int node, vector<vector<int>>& adj, vector<bool>& visited, int n) {
    visited[node] = true;

    for (int j = 0; j < n; j++) {
        if (adj[node][j] == 1 && !visited[j]) {
            dfs(j, adj, visited, n);
        }
    }
}

int main() {
    int n;
    cout << "Enter number of nodes: ";
    cin >> n;

    vector<vector<int>> adj(n, vector<int>(n));

    cout << "Enter adjacency matrix:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> adj[i][j];
        }
    }

    vector<bool> visited(n, false);
    int components = 0;

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i, adj, visited, n);
            components++;
        }
    }

    cout << "Number of connected components: " << components << endl;

    return 0;
}