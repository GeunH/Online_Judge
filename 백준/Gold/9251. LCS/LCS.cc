#include <iostream>
using namespace std;
int LCS[1001][1001];
int main()
{
	string A, B;
	cin >> A >> B;
	for (int i = 0; i < A.size(); i++)
	{
		for (int j = 0; j < B.size(); j++)
		{
			if (A[i] == B[j] )
			{
				LCS[i+1][j+1] = LCS[i][j] + 1;
			}
			else
			{
				LCS[i + 1][j + 1] = max(LCS[i][j+1], LCS[i + 1][j]);
			}
		}
	}
	cout << LCS[A.size()][B.size()];
	return 0;
}