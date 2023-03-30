#include <iostream>
using namespace std;

int arr[2][100000];
int dp[2][100000];

int main()
{
	int T, n;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> n;
		for (int j = 0; j < n; j++)
		{
			cin >> arr[0][j];
		}
		for (int j = 0; j < n; j++)
		{
			cin >> arr[1][j];
		}
		dp[0][0] = arr[0][0], dp[1][0] = arr[1][0];
		for (int j = 1; j < n; j++)
		{
			int jump = 0;
			if(j> 1)jump= max(dp[0][j - 2], dp[1][j - 2]);
			dp[0][j] = max(dp[1][j - 1] + arr[0][j], jump + arr[0][j]);
			dp[1][j] = max(dp[0][j - 1] + arr[1][j], jump + arr[1][j]);
		}
		cout << max( dp[0][n - 1], dp[1][n - 1] ) << endl;
	}
	return 0;
}