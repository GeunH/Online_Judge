#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int visited[100][100];

int stack_y[10000], stack_x[10000], top = -1;

int dir_y[4] = { -1, 0, 1 , 0};
int dir_x[4] = { 0 , 1 , 0 , -1};

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    
    for(int i=0; i<maps.size(); i++)
    {
        for(int j =0 ; j < maps[i].size() ; j++)
        {
            if(maps[i][j] != 'X' && visited[i][j] == 0)
            {
                int day =0;
                stack_y[++top] = i;
                stack_x[top] = j;
                
                while(top != -1)
                {
                    int y = stack_y[top];
                    int x = stack_x[top--];
                    visited[y][x] = 1;
                    day += (maps[y][x] - '0');
                    for(int i=0; i< 4; i++)
                    {
                        if( y + dir_y[i] >= 0 
                           && y + dir_y[i] < maps.size() 
                           && x + dir_x[i] >= 0 
                           && x + dir_x[i] < maps[i].size()
                          && visited[y + dir_y[i]][x + dir_x[i]] == 0
                          && maps[y+ dir_y[i]][x + dir_x[i]] != 'X' )
                        {
                           visited[y + dir_y[i]][x + dir_x[i]] = 1;
                           stack_y[++top]= y + dir_y[i];
                           stack_x[top] = x + dir_x[i];
                        }
                    }
                }
                if(day != 0) answer.push_back(day);
            }
        }
    }
    if(answer.empty() == 1)answer.push_back(-1);
    
    sort(answer.begin(), answer.end());
    return answer;
}