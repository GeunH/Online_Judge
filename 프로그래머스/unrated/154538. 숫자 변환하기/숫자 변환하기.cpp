#include <string>
#include <vector>

using namespace std;

int BFS[1000001];
int cnt[1000001];
int visit[1000001];
int front,rear;

int solution(int x, int y, int n) {
    int answer = -1;
    
    BFS[rear] = x;
    cnt[rear++] = 0;
    while( front < rear)
    {
        int now = BFS[front];
        int n_cnt = cnt[front++];
        visit[now]= 1;
        if( now == y)
        {
            answer= n_cnt;
            break;
        }
        if( now*2 <= y && visit[now*2] == 0)
        {
            visit[now*2] = 1;
            BFS[rear] = now*2;
            cnt[rear++] = n_cnt + 1;
        }
        if( now*3 <= y && visit[now*3] == 0)
        {
            visit[now*3] = 1;
            BFS[rear] = now*3;
            cnt[rear++] = n_cnt + 1;
        }
        if( now+n <= y && visit[now+n] == 0)
        {
            visit[now+n] = 1;
            BFS[rear] = now+n;
            cnt[rear++] = n_cnt + 1;
        }
    }
    return answer;
}