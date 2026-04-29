def solution(phone_book):
    answer = True
    
    dict = {}
    
    for i in range(len(phone_book)):
        dict[phone_book[i]] = 1
    
    for i in range(len(phone_book)):
        for j in range(len(phone_book[i])):
            if dict.get(phone_book[i][:j]) != None:
                answer = False
                return answer
    return answer