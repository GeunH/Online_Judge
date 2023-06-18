#include <iostream>
#include <string>
using namespace std;

char arr[5][15];

int main()
{
	int y, x, max_num = -1;
	string str;
	for (int i = 0; i < 5; i++)
	{
		getline(cin, str);
		for (int j = 0; j < str.length(); j++)
		{
			arr[i][j] = str[j];
		}
		for (int j = str.length(); j < 15; j++)
		{
			arr[i][j] = '\0';
		}
	}

	for (int i = 0; i < 15; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			if (arr[j][i] != '\0')
			{
				cout << arr[j][i];
			}
		}
	}

	return 0;
}
