#include <iostream>
#include <algorithm>

using namespace std;

int arr[100000];

int main()
{
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	sort(arr, arr + N);

	for (int i = 0; i < N; i++)
	{
		while (arr[i] == arr[i + 1])
		{
			i++;
		}
		cout << arr[i] << " ";
	}
	return 0;
}