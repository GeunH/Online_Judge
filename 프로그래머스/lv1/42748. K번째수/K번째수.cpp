#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;
int arr[100] = {0};

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(int i=0; i< commands.size() ;i++)
    {
        for(int j= commands[i][0]-1 ; j<= commands[i][1]-1; j++)    
        {
            arr[ j - (commands[i][0]-1)] = array[j]; 
        }
        sort(arr, arr + (commands[i][1] - commands[i][0]) + 1 );
        answer.push_back(arr[commands[i][2] - 1]);
    }
    return answer;
}