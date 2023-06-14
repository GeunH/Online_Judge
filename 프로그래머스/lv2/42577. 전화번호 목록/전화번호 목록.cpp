#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector <string> arr[10];

bool solution(vector<string> phone_book) {
    bool answer = true;

    sort( phone_book.begin(), phone_book.end() );
    
    for(int i=0; i< phone_book.size()-1; i++)
    {
        int cnt= 0;
        while(phone_book[i][cnt] == phone_book[i+1][cnt])
        {
            cnt++;
            if(phone_book[i][cnt] == 0)return false;
        }
    }
    return true;
}