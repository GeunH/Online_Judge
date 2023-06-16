#include <iostream>
#include <vector>
using namespace std;

int avr[20][20];

vector <int> start;
int s_score, l_score, min_dif;

void find_min(int now, int N, int cnt)
{
	if (cnt == N / 2)
	{
		vector<int>link;
		s_score = l_score=  0;
		for (int i = 0 ; i<  start.size(); i++)
		{
			for (int j = 0; j < start.size(); j++)
			{
				s_score += avr[start[i]][start[j]];
			}
		}
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < start.size(); j++)
			{
				if (i == start[j])break;
				if (j == start.size() - 1)link.push_back(i);
			}
		}

		for (int i = 0; i < link.size(); i++)
		{
			for (int j = 0; j < start.size(); j++)
			{
				l_score += avr[link[i]][link[j]];
			}
		}
		min_dif = min(min_dif, abs(l_score - s_score) );
		return;
	}

	for (int i = now; i < N; i++)
	{
		start.push_back(i);
		find_min(i + 1, N, cnt + 1);
		start.pop_back();
	}
}

int main()
{
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			cin >> avr[i][j];
			min_dif += avr[i][j];
		}
	}
	find_min(0, N, 0);
	cout << min_dif;
	return 0;
}