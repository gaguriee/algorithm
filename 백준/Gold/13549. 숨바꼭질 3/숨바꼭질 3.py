# 13549 숨바꼭질 3 [BFS]

import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

time=[0]*100001

def bfs(n,k) :


    q=deque()
    q.append(n)
    time[n]=1

    while q:
        curr_point=q.popleft()
        
        if curr_point==k:
            print(time[k]-1)
            break

        for i in (2*curr_point,curr_point-1,curr_point+1):

            if 0<=i<=100000 and time[i]==0:
                if i==2*curr_point:
                    time[i]=time[curr_point]
                    q.append(i)
                else:
                    time[i]=time[curr_point]+1
                    q.append(i)

bfs(N,K)