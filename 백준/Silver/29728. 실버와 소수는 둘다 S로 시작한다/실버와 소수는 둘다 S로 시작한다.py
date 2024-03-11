n = int(input())
a = [False,False] + [True]*(n-1)

B=0; # B의 개수
S=0; # S의 개수

first = ''
last = ''

for i in range(1,n+1):

    if a[i] : # 소수일 경우
        
        if last == 'B': # 마지막 문자가 B인 경우
            last = 'S'
            B-=1 
            S+=2 # 마지막 문자를 알파벳 S로 교체 후 A 끝에 S 하나 추가

        else: # 마지막 문자가 B가 아닐 경우
            S+=1 # S 하나 추가
            last = first # A 뒤집기

        if i != 1 :
            for j in range(2*i, n+1, i):
                a[j] = False
        
    else : # 소수가 아닐 경우
        B+=1 # B 개수에 1을 더한다.
        last = 'B'
    
    if first == '' :
        first = last



    
print(B,S)

