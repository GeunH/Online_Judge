#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    
    for(int i=0; i< section.size(); i++)
    {
        int length = m-1;
        while( length > 0 && (i+1 < section.size() )&& (section[i+1] <= (section[i] + length) ) )
        {
            length -= section[i+1] - section[i];
            i++;
        }
        answer++;
    }
    return answer;
}