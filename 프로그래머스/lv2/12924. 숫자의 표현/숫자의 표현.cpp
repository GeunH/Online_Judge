#include <string>
#include <vector>

using namespace std;

int cnt[10001];

void check(int sum, int i, int n)
{
    if( sum + i== n )
    {
        cnt[sum + i]++;
        return;
    }
    else if (sum + i > n)return;
    else check (sum + i, i + 1 , n); 
}

int solution(int n) {
    int answer = 0;
    for(int i= 1 ; i<= n ; i++)
    {
        check(0,i,n);
    }
    answer = cnt[n];
    return answer;
}