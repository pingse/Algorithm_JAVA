def solution(nums):
    answer = 0
    map = [0] * 200001
    
    for i in range(len(nums)):
        if (map[nums[i]] == 0):
            map[nums[i]] = 1
            answer+=1
            
        if len(nums) // 2 == answer:
            break
    return answer