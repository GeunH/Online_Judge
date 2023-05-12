#include <iostream>
#include <string>
#include <map>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	map<string, int > pocket;
	map<int, string > poc;
	int N, M;
	cin >> N >> M;
	string name;
	for (int i = 0; i < N; i++)
	{
		cin >> name;
		pocket.insert({ name , i + 1 });
		poc.insert({ i + 1, name });
	}

	for (int i = 0; i < M; i++)
	{
		cin >> name;
		if (name[0] >= 'A' && name[0] <= 'Z')
		{
			cout << pocket[name] << '\n';
		}
		else
		{
			cout << poc[stoi(name)] << '\n';
		}
	}
	return 0;
}