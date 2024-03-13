# 11726 2×n 타일링 [DP]

# 점화식 : dp[i] = dp[i-1] +dp[i-2] (i >=3)

N = int(input())

dp = [0] * (N + 1)

if N < 3 :
    print(N)

else :
    dp[1] = 1
    dp[2] = 2

    for i in range(3, N+1):

        dp[i] = (dp[i-1] + dp[i-2]) % 10007


    print(dp[N])
