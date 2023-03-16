#include <iostream>
using namespace std;

char map[10][10];
int r_f, r_r, b_f, b_r;

pair< pair <int, int>,int> red[500000];
pair <int, int> blue[500000];
pair<int, int> out;

int visited[10][10][10][10];
int d_y[4] = { -1, 0, 1, 0 };
int d_x[4] = { 0, 1, 0, -1 };

void move(int N, int M)
{
	int r_y, r_x, b_y, b_x, r_c, end = 0;
	while (red[r_f].second < 10 && r_f != r_r)
	{
		r_y = red[r_f].first.first, r_x = red[r_f].first.second;
		r_c = red[r_f++].second;

		b_y = blue[b_f].first, b_x = blue[b_f++].second;

		for (int i = 0; i < 4; i++)
		{	
			end = 0;
			int tr_y = r_y, tr_x = r_x, tb_y = b_y, tb_x = b_x, move;

			while ( !(map[tr_y + d_y[i]][tr_x + d_x[i]] == '#' && map[tb_y + d_y[i]][tb_x + d_x[i]] == '#'))
			{
				move = 0;
				if (map[tr_y + d_y[i]][tr_x + d_x[i]] != '#'
					&& !((tr_y + d_y[i] == tb_y && tr_x + d_x[i] == tb_x) && map[tb_y+ d_y[i]][tb_x + d_x[i]] == '#') )
				{
					tr_y += d_y[i];
					tr_x += d_x[i];
					move = 1;
				}
				if (map[tb_y + d_y[i]][tb_x + d_x[i]] != '#'
					&& !((tb_y + d_y[i] == tr_y && tb_x + d_x[i] == tr_x) && map[tr_y + d_y[i]][tr_x + d_x[i]] == '#') )
				{
					tb_y += d_y[i];
					tb_x += d_x[i];
					move = 1;
				}
				if (move == 0)break;
				if (map[tr_y][tr_x] == 'O')
				{
					end = 1;
					while (map[tb_y + d_y[i]][tb_x + d_x[i]] != '#')
					{
						tb_y += d_y[i];
						tb_x += d_x[i];
						if (map[tb_y][tb_x] == 'O')
						{
							end = 2;
							break;
						}
					}
					break;
				}
				if (map[tb_y][tb_x] == 'O')
				{
					end = 2;
					break;
				}
			}
			if (end == 1)
			{
				cout << r_c + 1;
				return;
			}
			else if (end == 2)continue;
			else
			{
				if (visited[tr_y][tr_x][tb_y][tb_x] == 0 )
				{
					red[r_r++] = { {tr_y,tr_x},r_c + 1 };
					blue[b_r++] = { tb_y,tb_x };
					visited[tr_y][tr_x][tb_y][tb_x] = 1;
				}
			}
		}
	}
	cout << -1;
	return;
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
			if (map[i][j] == 'B')blue[b_r++] = { i,j };
			else if (map[i][j] == 'R')red[r_r++] = { { i,j }, 0 };
			else if (map[i][j] == 'O')out = { i,j };
		}
	}
	move(N, M);
	return 0;
}