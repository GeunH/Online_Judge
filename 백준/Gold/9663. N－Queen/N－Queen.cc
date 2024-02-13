#include <iostream>

using namespace std;

int N, cnt;
int map[15][15], col[15], diag[30], diag2[30];

void search(int y)
{
	if (y == N)
	{
		cnt++;
		return;
	}
	for (int i = 0; i < N; i++)
	{
		if (col[i] || diag[i + y] || diag2[i - y + N - 1])
		{
			continue;
		}
		col[i] = diag[i + y] = diag2[i - y + N - 1] = 1;
		search(y + 1);
		col[i] = diag[i + y] = diag2[i - y + N - 1] = 0;
	}
}

int main()
{
	cin >> N;

	search(0);
	cout << cnt;
	return 0;
}