#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int N, a, b, cnt = 0;
    cin >> N >> a >> b;

    while (a != b) {
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        cnt++;
    }

    cout << cnt;

    return 0;
}