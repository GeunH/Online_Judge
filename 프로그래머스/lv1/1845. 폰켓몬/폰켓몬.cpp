#include <vector>
using namespace std;

int cnt[200001];
vector<int> list;

int solution(vector<int> nums)
{
    int answer = 0;
    for(int i=0; i< nums.size() ; i++)
    {   
        cnt[nums[i]]++;
    }
    
    for(int i=0; i<= 200000; i++)
    {
        if(cnt[i] != 0)
        {
            list.push_back(i);
        }
    }
    list.size() > nums.size()/2 ? answer = nums.size()/2 : answer = list.size();
    return answer;
}