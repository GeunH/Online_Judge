#include <string>
#include <vector>
using namespace std;

pair<int,int> left, up, right, down;

vector<int> solution(vector<string> wallpaper) 
{
    vector<int> answer;
    up = {wallpaper.size(), 0};
    left = {0,wallpaper[0].size()};
    right= {0,0};
    down = {0,0};
    for(int i=0;i <wallpaper.size(); i++)
    {
        for(int j=0; j < wallpaper[i].size(); j++)
        {
            if( wallpaper[i][j] == '#')
            {
                if( i < up.first ) up = {i,j};
                if( j < left.second ) left = {i,j};
                if( i > down.first ) down = {i,j};
                if( j > right.second ) right = {i,j};
            }
            
        }
    }
    answer.push_back(up.first);
    answer.push_back(left.second);
    answer.push_back(down.first+1);
    answer.push_back(right.second+1);
    return answer;
}