#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

map<string, int> arr;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    char last =' ';
    int cnt = 0;
    for(int i=0 ;i <words.size(); i++)
    {
        if( i%n == 0)cnt++;
        
        if(last != ' ' && (words[i][0] != last || arr.find(words[i]) != arr.end() ))
        {
            answer.push_back(i%n+1);
            answer.push_back(cnt);
            break;
        }
        else if( arr.find(words[i]) == arr.end() )
        {
            arr.insert({words[i],1});
        }

        last = words[i][words[i].length() -1];
    }
    if(answer.empty())
    {
        answer.push_back(0);
        answer.push_back(0);
    }

    return answer;
}