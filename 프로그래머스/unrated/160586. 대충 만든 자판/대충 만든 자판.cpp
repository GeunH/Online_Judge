#include <string>
#include <vector>
#include <iostream>

using namespace std;

int cnt[26];

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for(int i=0; i< keymap.size(); i++)
    {
        for(int j=0; j< keymap[i].size() ; j++)
        {
            if(cnt[keymap[i][j] -'A'] == 0)cnt[keymap[i][j]- 'A' ] = j+1;
            else cnt[keymap[i][j]- 'A' ] = min(cnt[keymap[i][j]- 'A' ], j+1);
        }
    }
    int num;
    for(int i=0; i< targets.size(); i++)
    {
        num = 0;
        for(int j=0; j< targets[i].size(); j++)
        {
            if( cnt[targets[i][j] -'A'] == 0)
            {
                num = -1;
                break;
            }
            else
            {   
                num += cnt[ targets[i][j] -'A' ];
            }
        }
        answer.push_back(num);
    }
    return answer;
}