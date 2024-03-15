N = int(input())

arr = list(map(int, input().split()))
stack = []
ans = []

for i in range(N):

    while stack:
        if stack[-1][1] > arr[i]:
            ans.append(stack[-1][0] + 1) 
            break
        else :
            stack.pop()
    
    if not stack :
        ans.append(0)

    stack.append([i, arr[i]])

print(" ".join(map(str, ans)))