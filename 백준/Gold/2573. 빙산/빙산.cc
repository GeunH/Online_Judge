#include <iostream>

using namespace std;

int map[300][300];
int melt[300][300];
int visit[300][300];
int flag = 0;
pair<int,int> stack[90000];
int top = -1;

int d_y[4] = { -1, 0, 1, 0 };
int d_x[4] = { 0, 1, 0, -1 };

bool check(int y, int x, int N, int M)
{
	if (y >= 0 && y < N && x >= 0 && x < M)
	{
		if (map[y][x] == 0)
		{
			return true;
		}
	}
	return false;
}

void melting(int N, int M)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			map[i][j] = map[i][j] - melt[i][j];
			if (map[i][j] < 0)
			{
				map[i][j] = 0;
			}
			melt[i][j] = 0;
		}
	}
}

void move(int y, int x,int N, int M)
{
	if (y > 0 && y < N-1 && x > 0 && x < M-1)
	{
		if (map[y][x] != 0 && visit[y][x] ==0)
		{
			stack[++top] = { y,x };
			visit[y][x] = 1;
		}
	}
}

int init_cnt;

void DFS(int N, int M, int year)
{
	int y, x;
	int cnt = 0;
	for (int i = 1; i < N-1; i++)
	{
		for (int j = 1; j < M-1; j++)
		{
			if (map[i][j] != 0 && visit[i][j] == 0)
			{
				visit[i][j] = 1;
				stack[++top] = { i,j };
				cnt++;
				if (init_cnt != 0 && cnt > init_cnt)
				{
					cout << year;
					flag = 1;
					return;
				}
				while (top != -1)
				{
					y = stack[top].first;
					x = stack[top--].second;
					for (int k = 0; k < 4; k++)
					{
						move(y + d_y[k], x + d_x[k], N, M);
					}
				}
			}
		}
	}
	if (init_cnt == 0)
	{
		init_cnt = cnt;
	}
}

void init(int N, int M)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			visit[i][j] = 0;
		}
	}
}

bool melt_everything(int N,int M)
{
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			if (map[i][j] != 0)
			{
				return false;
			}
		}
	}
	return true;
}

void when_divide(int N, int M )
{
	int year = 0;
	while(1)
	{
		if (melt_everything(N,M))break;
		DFS(N, M, year);
		init(N,M);
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				for (int k = 0; k < 4; k++)
				{
					if (check(i + d_y[k], j + d_x[k], N, M))
					{
						melt[i][j] += 1;
					}
				}
			}
		}

		melting(N, M);
		if (flag == 1)return;
		year++;
	}
	cout << 0;
}

int main()
{
	int N, M;

	cin >> N >> M;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> map[i][j];
		}
	}
	when_divide(N, M);

	return 0;
}