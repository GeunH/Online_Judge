#include <string>
#include <vector>

using namespace std;

vector<int> solution(int numer1, int denom1, int numer2, int denom2) {
        
    vector<int> answer;
    
    int under = denom1 * denom2;
    
    int upper = denom2 * numer1 + denom1 * numer2;
    
    for(int i=2; i< under; i++)
    {
        while(under %i == 0 && upper % i ==0)
    {
        under/=i;
        upper/=i;
    }
    }
    
    answer.push_back(upper);
    answer.push_back(under);
    return answer;
}