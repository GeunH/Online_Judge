#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int zero= 0 ,cnt =0, len= 0, t_cnt = 0;
    while(s != "1")
    {
        cnt =0;
        for(int i=0; i< s.length() ; i++)
        {
            if(s[i] == '0')cnt++;
        }
        len = s.length() - cnt;
        string now = "";
        while( len > 0)
        {
            now += to_string(len&1);
            len /=2;
        }
        reverse(now.begin(), now.end());
        s = now;
        zero += cnt;
        t_cnt ++;
    }
    answer.push_back(t_cnt);
    answer.push_back(zero);
    return answer;
}