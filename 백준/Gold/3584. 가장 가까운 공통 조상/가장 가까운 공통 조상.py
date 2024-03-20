import sys

c = int(sys.stdin.readline())
answer = []

for _ in range(c):

    N=int(sys.stdin.readline())
    tree= [0] * (N+1)
 
    for _ in range(N-1):
        a,b=map(int, sys.stdin.readline().split())
        tree[b] = a

    x,y=map(int, sys.stdin.readline().split()) # 공통조상 찾을 두 노드
    
    # x의 조상 집합 찾기
    x_parent = [] 
    while x:
        x_parent.append(x)
        x=tree[x]

    # x와 y의 공통 조상 찾기
    while y:
        if y in x_parent:
            answer.append(y)
            break
        y=tree[y]

for ans in answer:
    print(ans)
