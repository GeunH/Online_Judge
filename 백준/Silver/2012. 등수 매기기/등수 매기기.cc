#include <iostream>
#include <algorithm>
using namespace std;

int N;
int score[500000];
int main()
{
	cin >> N;
	
	for (int i = 0; i < N; i++)
	{
		cin >> score[i];
	}

	sort(score, score + N);

	long long temp=0;
	for (int i = 0; i < N; i++)
	{
		temp += max(score[i] - (i + 1), (i + 1) - score[i]);
	}
	cout << temp;
	return 0;
}