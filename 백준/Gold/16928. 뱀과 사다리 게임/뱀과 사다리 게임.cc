#include <iostream>
#include <queue>

using namespace std;

int N, M, arr[101],gone[101];

queue <pair<int , int >> way;

void find_shortway(int start)
{
	gone[start] = 1;
	way.push({ start,0 });

	while (way.empty() == 0)
	{
		for (int i = 1; i <= 6; i++)
		{
			if (way.front().first + i == 100)
			{
				cout << way.front().second + 1;
				return;
			}

			if (arr[way.front().first + i] != way.front().first + i + 1)
			{
				if (gone[arr[way.front().first + i]] == 0)
				{
					way.push({ arr[way.front().first + i] ,  way.front().second + 1 });
					gone[arr[way.front().first + i]] = 1;
				}
			}
			else
			{
				if (gone[way.front().first + i] == 0)
				{
					way.push({ way.front().first + i, way.front().second + 1 });
					gone[way.front().first + i] = 1;
				}
			}
		}
		way.pop();
	}
}

int main()
{
	int x, y, u, v;

	cin >> N >> M;

	for (int i = 1; i < 100; i++)
	{
		arr[i] = i + 1;
	}

	for (int i = 0; i < N; i++)
	{
		cin >> x >> y;
		arr[x] = y;
	}

	for (int i = 0; i < M; i++)
	{
		cin >> u >> v;
		arr[u] = v;
	}

	find_shortway(1);

	return 0;
}