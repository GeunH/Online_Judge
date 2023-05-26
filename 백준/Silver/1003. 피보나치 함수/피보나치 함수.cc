#include <iostream>
#include <algorithm>

using namespace std;

int zero_count[41];
int one_count[41];

int main()
{
	int N, num;

	cin >> N;

	zero_count[0] = 1;
	zero_count[1] = 0;
	one_count[0] = 0;
	one_count[1] = 1;

	for (int i = 0; i < N; i++)
	{
		cin >> num;

		for (int j = 2; j <= num; j++)
		{
			zero_count[j] = zero_count[j - 1] + zero_count[j - 2];
			one_count[j] = one_count[j - 1] + one_count[j - 2];
		}
		cout << zero_count[num] << " " << one_count[num] << endl;
	}

	 

	return 0;
}