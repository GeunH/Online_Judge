#include <iostream>
#include <algorithm>

using namespace std;

int flag = 0;

void make_S_to_T(string S, string T)
{
	if (T.size() == S.size())
	{
		if(flag == 0)S == T ? flag = 1 : flag = 0;
		return;
	}
	if (T[T.size()-1] == 'B')
	{
		if (T[0] == 'A')
		{
			return;
		}
		reverse(T.begin(), T.end());
		T.erase(T.size() - 1);
		make_S_to_T(S, T);
	}
	else
	{
		if (T[0] != 'B')
		{
			T.erase(T.size() - 1);
			make_S_to_T(S, T);
		}
		else
		{
			string C = T;
			C.erase(C.size() - 1);
			make_S_to_T(S, C);

			reverse(T.begin(), T.end());
			T.erase(T.size() - 1);
			make_S_to_T(S, T);
		}
	}
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