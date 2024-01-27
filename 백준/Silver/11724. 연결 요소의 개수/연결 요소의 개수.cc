#include <iostream>

using namespace std;

int arr[1001][1001];
int gone[1001];
int cnt = 0;
void DFS(int num, int V)
{
	gone[V] = 1;
	for (int i = 1; i <= num; i++)
	{
		if (arr[V][i] == 1 && gone[i] == 0)
		{
			DFS(num, i);
		}
	}

}

int main()
{
	int N, M, u, v;

	cin >> N >> M;

	for (int i = 0; i < M; i++)
	{
		cin >> u >> v;
		arr[u][v] = 1;
		arr[v][u] = 1;
	}

	for (int i = 1; i <= N; i++)
	{
		if (gone[i] == 0)
		{
			DFS(N, i);
			cnt++;
		}
	}
	cout << cnt;

	return 0;
}