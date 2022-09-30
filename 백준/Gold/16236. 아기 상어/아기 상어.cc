#include <iostream>
#include <algorithm>

using namespace std;

int front, rear;

pair<int, pair<int, int>> arr[1000];

pair<int, pair<int, int>> shark[1000];
int s_front;

int visited[20][20];
int map[20][20];
int level = 2;
int ate = 0;

void init(int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            visited[i][j] = 0;
        }
    }
    front = 0;
    rear = 0;
    return;
}

void check(int y, int x, int N, int cnt)
{
    if (visited[y][x] == 0)
    {
        if (y >= 0 && y < N && x >= 0 && x < N && map[y][x] <= level)
        {
            visited[y][x] = 1;
            arr[front++] = { cnt + 1, {y, x} };
            if (map[y][x] > 0 && map[y][x] < level)
            {
                shark[s_front++] = { cnt + 1, { y,x } };
            }
        }
    }
    return;
}

bool cant_eat(int N)
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (map[i][j] > 0 && map[i][j] < level)
            {
                return false;
            }
        }
    }
    return true;
}

void how_long(int N)
{
    int now_x, now_y, cnt = 0;
    int last_cnt = 0;
    while (1)
    {
        if (cant_eat(N))break;

        while (front != rear)
        {
            now_x = arr[rear].second.second;
            now_y = arr[rear].second.first;
            cnt = arr[rear++].first;

            check(now_y - 1, now_x, N, cnt);
            check(now_y, now_x - 1, N, cnt);
            check(now_y, now_x + 1, N, cnt);
            check(now_y + 1, now_x, N, cnt);
        }

        if (s_front == 0)break;

        sort(shark, shark + s_front);

        map[shark[0].second.first][shark[0].second.second] = 0;
        init(N);
        ate++;
        if (ate == level)
        {
            level++;
            ate = 0;
        }
        arr[front++] = { shark[0].first, {shark[0].second.first, shark[0].second.second} };
        last_cnt = shark[0].first;
        s_front = 0;
    }
    cout << last_cnt;
    return;
}

int main()
{
    int N;
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == 9)
            {
                map[i][j] = 0;
                visited[i][j] = 1;
                arr[front++] = { 0,{i,j} };
            }
        }
    }
    how_long(N);
    return 0;
}