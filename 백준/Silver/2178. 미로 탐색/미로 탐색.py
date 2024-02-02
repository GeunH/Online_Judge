import sys
import queue

dirY = [-1,0,1,0]
dirX = [0,1,0,-1]
class Position:
    def __init__(self, y, x, cnt):
        self.y= y
        self.x= x
        self.cnt = cnt 
    

def Main():
    N, M = map(int, input().split())
    isVisit = [[False for i in range(M)] for i in range(N)]
    place = [[0 for _ in range(M)] for _ in range(N)]

    for i in range(N):
        line = input()
        for j in range(M):
            place[i][j] = int(line[j])
    que = queue.Queue()
    que.put(Position(0,0,1))

    isVisit[0][0] = True
    while(not que.empty()):
        position = que.get()
        if(position.y == N-1 and position.x == M-1):
            answer = position.cnt
            break
        
        for i in range(4):
            nextY = position.y + dirY[i]
            nextX = position.x + dirX[i]
            cnt = position.cnt
            if ( nextY >= 0 and nextY < N and nextX>=0 and nextX < M
            and not isVisit[nextY][nextX] and place[nextY][nextX] == 1 ):
                isVisit[nextY][nextX] = True
                que.put(Position(nextY,nextX,cnt+1))
    print(answer)

Main()

