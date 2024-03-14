# 2156 포도주 시식 [DP]

N = int(input())

dp = [0] * (N + 1) # N번째 포도주까지 마셨을 때 최대로 마실 수 있는 양

array = [0] * (N + 1)

for i in range(1, N+1):
    array[i] = int(input())

    if N < 3:
        dp[N] += array[i]

if N >=3 :
    dp[1] = array[1]
    dp[2] = array[1] + array[2]

    for i in range(3, N+1):

        # 지금까지 먹는게 연속 2번째일 경우, 첫번째일 경우, 마시지 않을 경우 최적의 dp[i] 값
        
        second = dp[i-3] + array[i-1] + array[i]
        first = dp[i-2] + array[i]
        noteat = dp[i-1]

        dp[i] = max( second, first, noteat )



print(dp[N])
