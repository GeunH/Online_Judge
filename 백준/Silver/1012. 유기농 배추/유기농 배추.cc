#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int arr[51][51];
int gone[51][51];

queue<pair<int, int>> way;

int BFS(int M, int N)
{
	int cnt = 0;
	int x, y;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (arr[i][j] == 1 && gone[i][j] == 0)
			{
				cnt++;
				gone[i][j] = 1;
				way.push({ i,j });
				while (way.empty() == 0)
				{
					y = way.front().first;
					x = way.front().second;
					if (x + 1 < M && arr[y][x + 1] == 1 && gone[y][x + 1] == 0)
					{
						way.push({ y,x + 1 });
						gone[y][x + 1] = 1;
					}
					if (x - 1 >= 0 && arr[y][x - 1] == 1 && gone[y][x - 1] == 0)
					{
						way.push({ y,x - 1 });
						gone[y][x - 1] = 1;
					}
					if (y + 1 < N && arr[y + 1][x] == 1 && gone[y + 1][x] == 0)
					{
						way.push({ y + 1,x});
						gone[y + 1][x] = 1;
					}
					if (y - 1 >= 0 && arr[y - 1][x] == 1 && gone[y - 1][x] == 0)
					{
						way.push({y- 1,x });
						gone[y - 1][x] = 1;
					}
					way.pop();
				}
			}
		}
	}
	return cnt;
}

int main()
{
	int T, M, N, K, X, Y;

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> M >> N >> K;

		for (int j = 0; j < K; j++)
		{
			cin >> X >> Y;
			arr[Y][X] = 1;
		}
		cout << BFS(M, N) << endl;
		memset(arr, 0, sizeof(arr));
		memset(gone, 0, sizeof(gone));
	}

	return 0;
}