# 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
# 2-1. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
#   a) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
#   b) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
# 2-2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
#       반시계 방향으로 90도 회전한다.
#       바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
#       1번으로 돌아간다.

N, M = map(int, input().split())

r, c, d = map(int, input().split())

arr = [[0]*M for _ in range(N)] 
visited = [[False]*M for _ in range(N)] 

# d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

cnt = 0

for i in range(N) :
    arr[i] = list(map(int, input().split()))

while r >= 0 and r <= N-1 and c >= 0 and c <= M-1 :

    if arr[r][c] == 0 and visited[r][c] == False :
        cnt += 1
        visited[r][c] = True

    # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
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
        back = (d+2) % 4 # 0일땐 2, 1일땐 3, 2일땐 0, 3일땐 1 (후진)
        nx, ny = r + dx[back], c + dy[back]

        if arr[nx][ny] == 0: 
                r, c = nx, ny
        else :
            break


print(cnt)