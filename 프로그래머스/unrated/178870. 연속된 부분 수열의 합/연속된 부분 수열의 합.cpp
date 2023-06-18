#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    int num =0,start, end = sequence.size() -1, s_i= -1, e_i= -1;
    for(int i= sequence.size() - 1 ; i>= 0 ; i--)
    {
        num += sequence[i];
        start = i;
        while( num > k)
        {
            num -= sequence[end];
            end--;
        }
        if (num == k)
        {
            if( s_i == -1 && e_i == -1)
            {
                s_i = i;
                e_i = end;
            }
            else if( end - i <= e_i - s_i)
            {
                e_i = end;
                s_i = i;
            }
        }
    }

    answer.push_back(s_i);
    answer.push_back(e_i);
    
    return answer;
}