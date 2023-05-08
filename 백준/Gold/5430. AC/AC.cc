#include <iostream>
#include <string>

using namespace std;
int arr[100000];

int main()
{
	string a;
	int T, num;
	char o;
	cin >> T;

	for (int i = 0; i < T; i++)
	{
		cin >> a >> num;
		if (num == 0)cin >> o;
		for (int j = 0; j < num; j++)
		{
			cin >>  o >> arr[j];
		}
		cin >> o;
		int rev = 0, start = 0, end = num;
		for (int j = 0; j < a.length(); j++)
		{
			if (a[j] == 'D')
			{
				if (rev == 0)start++;
				else end--;

				if (start > end)break;
			}
			else
			{
				rev = ( rev + 1 )% 2;
			}
		}
		if (start > end) cout << "error" << endl;
		else
		{
			cout << '[';
			if (rev == 0)
			{
				for (int j = start; j < end; j++)
				{
					cout << arr[j];
					if (j < end - 1)cout << ',';
				}
			}
			else
			{
				for (int j = end - 1; j >= start; j--)
				{
					cout << arr[j];
					if (j > start)cout << ',';
				}
			}
			cout << ']' << endl;
		}
	}

	return 0;
}