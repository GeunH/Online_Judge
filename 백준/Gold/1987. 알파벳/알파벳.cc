#include <iostream>

using namespace std;

int R, C, max_cnt;
char map[20][20];
int visited[26];

void DFS(int y, int x, int cnt)
{
	visited[map[y][x]-'A'] = 1;
	if (cnt > max_cnt)max_cnt = cnt;

	if (y > 0 && visited[map[y - 1][x] -'A'] == 0)
	{
		DFS(y - 1, x, cnt +1 );
	}
	if (y < R - 1  && visited[map[y + 1][x] - 'A'] == 0)
	{
		DFS(y + 1, x, cnt + 1);
	}
	if (x > 0 && visited[map[y][x - 1] - 'A'] == 0)
	{
		DFS(y, x - 1, cnt + 1);
	}
	if (x < C - 1&& visited[map[y][x + 1] - 'A'] == 0)
	{
		DFS(y, x + 1, cnt + 1);
	}
	visited[map[y][x] - 'A'] = 0;
}

int main()
{
	cin >> R >> C;

	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			cin >> map[i][j];
		}
	}
	
	DFS(0, 0, 1);
	cout << max_cnt;
	return 0;
}