#include <string>
#include <vector>

using namespace std;

pair<int,int > dir[4] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int y,x;
    for(int i=0; i< park.size();i++)
    {
        for(int j=0; j< park[0].size() ; j++)
        {
            if( park[i][j] == 'S')
            {
                y= i;
                x =j;
            }
        }
    }
    
    for(int i=0; i<routes.size(); i++)
    {
        int where = 0;
        switch (routes[i][0])
        {
            case 'N':
                {
                    where =0;
                    break;
                }
            case 'E':
                {
                    where =1;
                    break;
                }
            case 'S':
                {
                    where =2;
                    break;
                }
            case 'W':
                {
                    where =3;
                    break;
                }
        }
        int temp_y =y, temp_x = x;
        for(int j=0; j< routes[i][2]- '0'; j++)
        {
            temp_y+= dir[where].first;
            temp_x+= dir[where].second;
            if((temp_y >= park.size() || temp_y < 0 || temp_x >= park[0].size() || temp_x < 0 )
               || park[temp_y][temp_x]== 'X')break;
            if( j == routes[i][2]- '0'-1)
            {
                y = temp_y;
                x = temp_x;
            }
        }          
    }
    answer = {y,x};
    return answer;
}