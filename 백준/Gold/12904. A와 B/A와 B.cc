#include <iostream>
#include <algorithm>

using namespace std;

int flag = 0;

void make_S_to_T(string S, string T)
{
	if (T.size() == S.size() )
	{
		S == T ? flag = 1 : flag = 0;
		return;
	}
	if (T[T.size() - 1] == 'A')
	{
		T.erase(T.size() - 1);
	}
	else
	{
		T.erase(T.size() - 1);
		reverse(T.begin(), T.end());
	}
	make_S_to_T(S, T);
}

int main()
{
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string S, T;
	cin >> S >> T;

	make_S_to_T(S, T);
	cout << flag;
	return 0;
}