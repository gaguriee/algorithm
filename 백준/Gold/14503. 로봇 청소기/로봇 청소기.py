# 14503 로봇 청소기 [DFS]

N, M = map(int, input().split())

r, c, d = map(int, input().split())

arr = [[0]*M for _ in range(N)] 
visited = [[False]*M for _ in range(N)] 

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0

for i in range(N) :
    arr[i] = list(map(int, input().split()))

while r >= 0 and r <= N-1 and c >= 0 and c <= M-1 :

    if arr[r][c] == 0 and visited[r][c] == False :
        cnt += 1
        visited[r][c] = True

    isBlank = False

    for i in range(4):
            nx, ny = r + dx[i], c + dy[i] 
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and arr[nx][ny] == 0 : 
                isBlank = True
    
    if isBlank :
        for _ in range(4):
            if d == 0 : d = 3 
            else : d -= 1
            nx, ny = r + dx[d], c + dy[d] 
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and arr[nx][ny] == 0 :
                cnt += 1
                visited[nx][ny] = True
                r, c = nx, ny
                break
    
    else :
        back = (d+2) % 4 
        nx, ny = r + dx[back], c + dy[back]

        if arr[nx][ny] == 0: 
                r, c = nx, ny
        else :
            break


print(cnt)
