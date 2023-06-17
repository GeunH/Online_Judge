#include <iostream>

using namespace std;

int N;
int num[11];
int sign[4];
int now_sign[11];
int sign_cnt = 0;
int max_num= -1000000000, min_num = 1000000000;

void find_min(int cnt)
{
	if (cnt == N-1)
	{
		int last = num[0];
		for (int i = 0; i < cnt; i++)
		{
			if (now_sign[i] == 0)
			{
				last += num[i + 1];
			}
			else if (now_sign[i] == 1)
			{
				last -= num[i + 1];
			}
			else if (now_sign[i] == 2)
			{
				last *= num[i + 1];
			}
			else
			{
				last /= num[i + 1];
			}
		}

		if (last > max_num)max_num = last;
		if (last < min_num)min_num = last;
		return;
	}
	
	for (int i = 0; i < 4; i++)
	{
		if (sign[i] > 0)
		{
			sign[i] -= 1;
			now_sign[sign_cnt++] = i;
			find_min(cnt + 1);
			sign_cnt--;
			sign[i] += 1;
		}
	}
}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> num[i];
	}
	for (int i = 0; i < 4; i++)
	{
		cin >> sign[i];
	}


	find_min(0);
	cout << max_num << endl << min_num;
	return 0;
}