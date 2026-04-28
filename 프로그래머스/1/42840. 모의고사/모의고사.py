def solution(answers):
    s = [0, 0, 0]
    answer = []
    people = [[1, 2, 3, 4, 5],
              [2,1,2,3,2,4,2,5],
              [3,3,1,1,2,2,4,4,5,5]]
    
    for i in range(3):
        for j in range(len(answers)):
            if answers[j] == people[i][j % len(people[i])]:
                s[i]+=1
        
    maxValue = max(s[0], max(s[1], s[2]))
    
    for i in range(3):
        if (s[i] == maxValue):
            answer.append(i+1)
    
    return answer