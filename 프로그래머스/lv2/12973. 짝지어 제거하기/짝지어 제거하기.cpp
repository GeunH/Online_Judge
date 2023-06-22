#include <iostream>
#include<string>

using namespace std;

int top = -1;

char stack[1000001];

int solution(string s)
{
    int answer= 0;
    int i= 0;
    for(int i=0; i< s.length(); i++)
    {
        if(top > -1 && s[i] == stack[top])
        {
            top--;
        }
        else
        {
            stack[++top] = s[i];
        }
    }
    if(top == -1)answer =1;
    return answer;
}