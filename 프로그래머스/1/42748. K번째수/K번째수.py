def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        copyList = array[commands[i][0]-1:commands[i][1]]
        copyList.sort()
        answer.append(copyList[commands[i][2]-1])
    return answer