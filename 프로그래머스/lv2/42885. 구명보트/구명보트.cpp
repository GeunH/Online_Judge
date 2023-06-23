#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp ( int a, int b)
{
    return a> b;
}

int solution(vector<int> people, int limit) {
    int answer = 0, last = people.size() -1;
    
    sort(people.begin(), people.end(), cmp);
    
    for(int i=0; i<= last; i++)
    {
        int sum = people[i];
        
        while(sum + people[last] <= limit)
        {
            sum += people[last];
            last--;
        }
        answer++;
    }
    return answer;
}