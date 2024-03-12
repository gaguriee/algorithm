# 2667 단지번호붙이기 [DFS]

from collections import deque

# 입력 받기
N = int(input())
grid = [list(input()) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y):
    stack = deque([(x, y)])
    visited[x][y] = True
    count = 1

    while stack:
        x, y = stack.pop()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and grid[nx][ny] == '1':
                stack.append((nx, ny))
                visited[nx][ny] = True
                count += 1
    return count

# 각 구역의 크기를 저장할 리스트
sizes = []

# 모든 칸에 대해 DFS 실행
for i in range(N):
    for j in range(N):
        if grid[i][j] == '1' and not visited[i][j]:
            size = dfs(i, j)
            sizes.append(size)


print(len(sizes)) 
sizes.sort()
for size in sizes:
    print(size)  