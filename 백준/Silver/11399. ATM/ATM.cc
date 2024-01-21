#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int arr[1000] = { 0 };
	int N;
	
	cin >> N;
	
	for(int j=0 ; j <N ; j++)
	{
		cin >> arr[j];
	}

	sort(arr, arr + N);

	int sum = 0;

	for (int j = 0; j < N; j++)
	{
		if (j > 0)
		{
			arr[j] = arr[j - 1] + arr[j];
		}
		sum += arr[j];
	}

	cout << sum;
	return 0;
}