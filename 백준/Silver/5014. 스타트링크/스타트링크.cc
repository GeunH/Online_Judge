#include <iostream>

using namespace std;
int visited[1000001];

pair<int, int> BFS[1000001];
int front=0, rear=0;

int main()
{
	// 10 1 4 10 1
	int F, S, G, U, D;
	cin >> F >> S >> G >> U >> D;
	BFS[rear++] = { S, 0 };
	int now,cnt;
	while (front < rear)
	{
		now = BFS[front].first;
		cnt = BFS[front++].second;
		visited[now] = 1;
		if (now == G)
		{
			cout << cnt;
			return 0;
		}
		if ( ((now + U ) <= F) && visited[now + U] == 0)
		{
			BFS[rear++] = { now + U, cnt + 1 };
			visited[now + U] = 1;
		}
		if ( ((now - D) > 0) && visited[now - D] == 0)
		{
			BFS[rear++] = { now - D, cnt + 1 };
			visited[now - D] = 1;
		}
	}
	cout << "use the stairs";
	return 0;
}
