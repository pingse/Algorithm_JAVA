from collections import defaultdict

def solution(participant, completion):
    answer = ''
    map = defaultdict(lambda : 0);
    for name in completion:
        map[name] += 1;
        
    for name in participant:
        if name in map:
            if map[name] == 0:
                answer = name
            else:
                map[name] -= 1
        
        else:
            answer = name
            
        if answer != '':
            break
    return answer