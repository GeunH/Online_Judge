#include <iostream>

using namespace std;
int N;

char map[100][100];

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> map[i][j];
		}
	}
	int cnt = 0, row = 0, col = 0;
	for (int i = 0; i < N; i++)
	{
		cnt = 0;
		for (int j = 0; j < N; j++)
		{
			if (map[i][j] == '.')cnt++;
			else cnt = 0;
			if (cnt == 2)
			{
				row++;
			}
		}
	}
	for (int j = 0; j < N; j++)
	{
		cnt = 0;
		for (int i = 0; i < N; i++)
		{
			if (map[i][j] == '.')cnt++;
			else cnt = 0;
			if (cnt == 2)
			{
				col++;
			}
		}
	}
	cout << row << " " << col;
	return 0;
}