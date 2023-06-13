#include <string>
#include <vector>
#include <map>

using namespace std;
map <string,int> name; 
string solution(vector<string> participant, vector<string> completion) 
{
    string answer = "";
    for(int i=0; i< participant.size(); i++)
    {   
        if( name.find(participant[i]) == name.end())
        {
            name.insert({participant[i], 1});
        }
        else
        {
            name[participant[i]]++;
        }
    }
    
    for(int i=0; i< completion.size(); i++)
    {
        if( name.find(completion[i]) == name.end())
        {
            answer = completion[i];
            return answer;
        }
        else
        {
            name[completion[i]]--;
        }
    }
    
    for (auto iter = name.begin() ; iter !=  name.end(); iter++)
    {
        if(iter->second != 0)
        {
            answer = iter->first;
        }
    }
    return answer;
}