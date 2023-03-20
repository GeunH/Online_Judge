#include <iostream>

using namespace std;

int arr[41];

int dp[41];

int main()
{
	int N, M, num;
	cin >> N;
	cin >> M;
	for (int i = 0; i < M; i++)
	{
		cin >> num;
		arr[num] = 1;
	}

	dp[1] = 1;
	for (int i = 2; i <= N; i++)
	{
		if (arr[i] == 1 || arr[i-1] == 1)
		{
			dp[i] = dp[i - 1];
		}
		else
		{
			if (i == 2) dp[2] = 2;
			else
			{
				dp[i] = dp[i - 2] + dp[i-1];
			}
		}
	}
	cout << dp[N];
	return 0;
}