#include <iostream>

using namespace std;

char arr[11];

int main()
{
	cin >> arr;


	for (int i = 0; i < 11; i++)
	{
		for (int j = 0; j < 11; j++)
		{
			if (arr[i] > arr[j]) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	cout << arr;
	return 0;
}