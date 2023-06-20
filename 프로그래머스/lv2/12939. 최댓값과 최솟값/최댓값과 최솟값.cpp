#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    int max_num , min_num, first =0;
    for(int i=0; i< s.length(); i++)
    {
        string num ="";
        while( i< s.length() &&  s[i] !=' ' )
        {
            num +=s[i];
            i++;
        }       
        if( first == 0)
        {
            first = 1;
            max_num = stoi(num);
            min_num = stoi(num);
        }
        else
        {
            if( max_num <= stoi(num))max_num = stoi(num);
            if( min_num >= stoi(num))min_num = stoi(num);
        }
    }
    answer = to_string(min_num) + ' ' + to_string(max_num);
    return answer;
}