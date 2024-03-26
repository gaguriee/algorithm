# 감소하는 수
import sys
from itertools import combinations

input = sys.stdin.readline

n = int(input())

ans = []

for i in range(1, 11): 
    for j in combinations(range(10), i):  # 0-10 중 반복 가능한 i개의 객체(i자리 수)로 조합 생성
        result = sorted(j, reverse=True) 
        ans.append(int("".join(map(str, result))))

ans.sort()
if len(ans) > n :
    print(ans[n])
else:
    print(-1)
