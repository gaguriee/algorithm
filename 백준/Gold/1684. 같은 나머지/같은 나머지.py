# 684 같은 나머지
import sys
from math import gcd

input = sys.stdin.readline

def find_gcd(arr):
    current_gcd = arr[0]
    for number in arr[1:]:
        current_gcd = gcd(current_gcd, number)
        if current_gcd == 1:
            break
    return current_gcd

n = int(input().strip())  
arr = list(map(int, input().strip().split())) 

diff = [abs(arr[i] - arr[i-1]) for i in range(1, n)]

ans = find_gcd(diff)

print(ans)