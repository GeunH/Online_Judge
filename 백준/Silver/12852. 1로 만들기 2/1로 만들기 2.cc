#include <iostream>
using namespace std;

int dp[1000000], first[1000000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	
	for (int i = 2; i <= N; i++)
	{
		if (i % 3 == 0 && i % 2 == 0)
		{
			dp[i] = min(dp[i / 3], min(dp[i - 1], dp[i / 2]));
		}
		else if (i % 3 == 0)
		{
			dp[i] = min(dp[i / 3], dp[i - 1]);
		}
		else if (i % 2 == 0)
		{
			dp[i] = min(dp[i / 2], dp[i - 1]);
		}
		else
		{
			dp[i] = dp[i - 1];
		}
		dp[i] += 1;
	}
	cout << dp[N] << endl;

	int i = N;
	while (i >= 1)
	{
		cout << i << " ";
		if (i%3 == 0 && dp[i] == dp[i / 3] + 1)
		{
			i = i / 3;
		}
		else if ( i % 2 == 0 && dp[i] == dp[i / 2] + 1)
		{
			i = i / 2;
		}
		else
		{
			i--;
		}
	}
	return 0;
}