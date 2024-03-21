# 1916 최소비용 구하기 [Dijkstra]

import sys
import heapq

INF = 1e10

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

graph = [[INF for _ in range(N+1)] for _ in range(N+1)]

graph = [[INF for _ in range(N+1)] for _ in range(N+1)]

for _ in range(M) :
    start, end, pay = map(int, sys.stdin.readline().split())
    graph[start][end] = min(graph[start][end], pay)

x, y = map(int, sys.stdin.readline().split())

ans = [INF for _ in range(N+1)]

def dijkstra(start) :
    ans[start] = 0
    heap = []
    heap.append([start, 0])

    while heap :
      start, cost = heapq.heappop(heap)
      if ans[start] < cost :
        continue
      
      for idx, value in enumerate(graph[start]) :
        next_cost = cost + value
        if ans[idx] > next_cost : # 갱신할 비용이 minimum일 경우
            ans[idx] = next_cost
            heapq.heappush(heap, [idx, next_cost])
  
dijkstra(x) 
     
print(ans[y])