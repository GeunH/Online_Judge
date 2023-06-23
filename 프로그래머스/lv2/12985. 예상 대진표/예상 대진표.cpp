#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 1;

    
    int A = min(a,b);
    int B = max(a,b);
    
    while(!(A+1 == B && B%2==0 ))
    {
        if(A%2 == 0)A/=2;
        else A = (A+1)/2;
        if( B%2 == 0)B/=2;
        else B = (B+1)/2;
        
        answer++;
    }

    return answer;
}