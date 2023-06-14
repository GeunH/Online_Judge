#include <string>
#include <vector>

using namespace std;
    
int check_one[10] ={1,2,3,4,5,1,2,3,4,5};
int check_two[8] = {2,1,2,3,2,4,2,5};
int check_thr[10] = {3,3,1,1,2,2,4,4,5,5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int cnt[3] = {0,0,0},max_cnt = 0;
    for(int i=0; i< answers.size(); i++)
    {
        if( answers[i] == check_one[i%10] )cnt[0]++;
        if( answers[i] == check_two[i%8] )cnt[1]++;
        if( answers[i] == check_thr[i%10] )cnt[2]++;
    }
    max_cnt = max(cnt[0], max(cnt[1], cnt[2]));
    for(int i=0 ; i< 3; i++)
    {
        if( cnt[i] == max_cnt)answer.push_back(i+1);
    }
    return answer;
}