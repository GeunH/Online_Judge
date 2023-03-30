#include <iostream>

using namespace std;

int triangle[500][500];

int main()
{
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			cin >> triangle[i][j];
		}
	}
	
	for (int i = N - 1; i > 0; i--)
	{
		for (int j = 1; j <= i; j++)
		{
			if (j > 0 )
			{
				triangle[i][j] > triangle[i][j - 1] ? triangle[i - 1][j-1] += triangle[i][j] : triangle[i - 1][j-1] += triangle[i][j - 1];
			}
		}
	}
	cout << triangle[0][0];
	return 0;
}