# 11286 절댓값 힙 

import sys, heapq

N = int(sys.stdin.readline())
heap = []

for i in range(N):
    x = int(sys.stdin.readline())
    if x == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)

    else:
        heapq.heappush(heap, [abs(x), x]) 
