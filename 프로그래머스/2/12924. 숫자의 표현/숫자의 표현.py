def solution(n):
    answer = 0
    l, r, sum = 1, 1, 1
    
    while r <= n :
        if sum == n :
            answer+=1
        
        if sum >= n :
            sum -= l
            l += 1
        else :
            r += 1
            sum += r
    return answer