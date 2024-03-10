N = int(input())

t = []
p = []

dp = [0 for i in range(N+1)] 

for i in range(N):
    T, P = map(int, input().split())
    t.append(T)
    p.append(P)

for i in range(N):

    dp[i] = max(dp[:i+1])

    if(i+t[i] <= N ): 

        dp[i+t[i]] = max(dp[i] + p[i] , dp[i+t[i]]) 

print(max(dp))
