#include <iostream>

using namespace std;

int arr[9][9];

int main()
{
	int y, x, max_num = -1;
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cin >> arr[i][j];
			if (arr[i][j] > max_num)
			{
				max_num = arr[i][j];
				y = i + 1, x = j + 1;
			}
		}
	}

	cout << max_num << endl << y << " " << x;
	return 0;
}