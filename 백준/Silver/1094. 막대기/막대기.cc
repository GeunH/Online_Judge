#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int X, cnt = 0;
    cin >> X;

    while (X > 0) {
        if (X % 2 == 1) {
            cnt++;
        }
        X /= 2;
    }

    cout << cnt;

    return 0;
}