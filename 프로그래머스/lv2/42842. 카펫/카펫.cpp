#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int total = brown + yellow;
    
    for(int i=3 ; i<=total ; i++)
    {
        if( total % i == 0)
        {
            int big = max(i, total/i);
            int small = min(i ,total/i);
            
            if( (big + small)*2 -4 == brown)
            {
                answer.push_back(big);
                answer.push_back(small);
                break;
            }
        }
    }
    return answer;
}