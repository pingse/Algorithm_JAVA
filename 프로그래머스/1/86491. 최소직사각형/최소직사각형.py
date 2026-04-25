def solution(sizes):
    answer = 0
    maxW = 0
    maxH = 0
    
    for i in range(len(sizes)):
        w = max(sizes[i][0], sizes[i][1])
        h = min(sizes[i][0], sizes[i][1])
        
        maxW = max(w, maxW)
        maxH = max(h, maxH)
        
    answer = maxW * maxH
    return answer