def solution(arr):
    answer = []
    answer.append(arr[0])
    if (len(arr) == 1):
        return answer

    for i in range(1, len(arr)):
        if answer[len(answer)-1] != arr[i]:
            answer.append(arr[i])
    return answer