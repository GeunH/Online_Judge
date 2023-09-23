#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int N, M, length = 0;

    cin >> N >> M;
   
    int position,lastPosition = 0;
    for (int i = 0; i < M; i++) {
        cin >> position;
        if (i == 0)length = position;
        else {
            if (position <= N) {
                double interval = round(((double)position - (double)lastPosition) / 2);
                if (interval > length) {
                    length = interval;
                }
                lastPosition = position;
            }
        }
    }
    if ( lastPosition != N && N - lastPosition  > length)length = N - lastPosition;
    cout << length;
    return 0;
}