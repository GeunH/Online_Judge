#include <iostream>

using namespace std;

int N;
int arr[1001];
int cnt[1001];
int max_cnt=1;
void find_longest()
{
	for (int i = 0; i < N; i++)
	{
		cnt[i] = 1;
	}
	int j;
	for (int i = 1; i < N; i++)
	{
		j = i;

		while (j >= 0)
		{
			if (arr[j] < arr[i])
			{
				cnt[i] = max(cnt[i], cnt[j] + 1);
			}
			j--;
		}

		if (max_cnt < cnt[i])
		{
			max_cnt = cnt[i];
		}
	}
	cout << max_cnt;
}

int main()
{
	int num;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}

	find_longest();

	return 0;
}