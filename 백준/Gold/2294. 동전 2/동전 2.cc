#include <iostream>
#define INF 0x3fffffff
using namespace std;

int coin[101];
int dp[10001];

int main()
{
	int n, k;
	cin >> n >> k;

	for (int i = 1; i <= n; i++)
	{
		cin >> coin[i];
		if( coin[i] <= 10000)dp[coin[i]] = 1;
	}

	for (int i = 1; i <= k; i++)
	{
		dp[i] = INF;
		for (int j = 1; j <= n; j++)
		{
			if (i - coin[j] >= 0)
			{
				dp[i] = min(dp[i], dp[i - coin[j]] + 1);
			}
		}
	}

	if (dp[k] == INF)cout << -1;
	else cout << dp[k];

	return 0;
}