#include <iostream>

using namespace std;

int arr[1000], dp[1000], max_cnt;
void check(int N)
{
	for (int i = 0; i < N; i++)
	{
		dp[i] = 1;
		for (int j = 0; j < N; j++)
		{
			if(arr[i] > arr[j] && dp[i] < dp[j]+1)
			{
				dp[i] = dp[j] + 1;
			}
		}
		if (max_cnt < dp[i])max_cnt = dp[i];
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	check(N);
	cout << max_cnt;
	return 0;
}