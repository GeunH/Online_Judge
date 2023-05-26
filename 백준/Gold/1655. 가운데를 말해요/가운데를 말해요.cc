#include <iostream>
#include <queue>

using namespace std;

priority_queue<int> small;
priority_queue<int, vector<int>, greater<int> > big;

int main()
{
	cin.tie(NULL);
	int N, num;
	cin >> N;
	int big_size = 0, small_size = 0,middle;
	for (int i = 0; i < N; i++)
	{
		cin >> num;
		if (i == 0)
		{
			middle = num;
			big.push(num);
			printf("%d\n", big.top());
			big_size++;
		}
		else
		{
			if (middle < num)
			{
				big.push(num);
				big_size++;
				if (big_size > small_size)
				{
					int temp = big.top();
					middle = temp;
					big.pop();
					big_size--;
					small.push(temp);
					small_size++;
				}
				if (big_size == small_size)
				{
					middle = small.top();
				}
			}
			else
			{
				small.push(num);
				small_size++;
				if (big_size < small_size)
				{
					int temp = small.top();
					small.pop();
					small_size--;
					big.push(temp);
					big_size++;
				}
				if (big_size == small_size)
				{
					middle = small.top();
				}
			}
			printf("%d\n", middle);
		}
	}

	return 0;
}