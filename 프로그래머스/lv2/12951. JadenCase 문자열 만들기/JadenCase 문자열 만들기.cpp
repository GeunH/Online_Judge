#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    for(int i=0; i< s.length(); i++)
    {
        int first = 0;
        while(i < s.length() && s[i] != ' ')
        {
            if (first == 0 && s[i] >= 'a' && s[i] <= 'z')
            {
                first = 1;
                s[i] -= 32;
            }   
            else if (first == 1 && s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] += 32;
            }
            first = 1;
            i++;
        }
    }
    return s;
}