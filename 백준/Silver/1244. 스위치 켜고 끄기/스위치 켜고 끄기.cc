#include <iostream>

using namespace std;

int arr[100];

int main()
{
	int N, s, sex,num;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	cin >> s;
	for (int i = 0; i < s; i++)
	{
		cin >> sex >> num;
		if (sex == 1)
		{
			for (int j = num; j <= N; j = j + num)
			{
				if ( arr[j - 1] == 1)
				{
					arr[j - 1] = 0;
				}
				else
				{
					arr[j - 1] = 1;
				}
			}
		}
		else
		{
			if (arr[num - 1] == 1)arr[num - 1] = 0;
			else arr[num - 1] = 1;
			int cnt = 1;
			while ((num-1 +cnt < N && num-1 -cnt >= 0) && arr[num - 1 + cnt] == arr[num - 1 - cnt])
			{
				if (arr[num - 1 + cnt] == 1)
				{
					arr[num - 1 + cnt] = arr[num - 1 - cnt] = 0;
				}
				else 
				{
					arr[num - 1 + cnt] = arr[num - 1 - cnt] = 1;
				}
				cnt++;
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		if (i > 0 && i % 20 == 0)cout << endl;
		cout << arr[i] << " ";
	}
	
	return 0;
}