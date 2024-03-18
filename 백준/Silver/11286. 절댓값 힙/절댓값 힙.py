# 11286 절댓값 힙 

import sys, heapq

N = int(sys.stdin.readline()) # 시간초과 방지
heap = []

for i in range(N):
    x = int(sys.stdin.readline())
    if x == 0:
        if heap:
            print(heapq.heappop(heap)[1]) # 실제 값만 출력
        else:
            print(0)

    else:
        heapq.heappush(heap, (abs(x), x)) # 튜플로 push 
