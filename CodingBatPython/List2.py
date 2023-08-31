def count_evens(nums):
    count = 0
    for i in range(0, len(nums)):
        if nums[i] % 2 == 0:
            count += 1
    return count

def big_diff(nums):
    return max(nums) - min(nums)

def centered_average(nums):
    total = 0
    for i in range(0, len(nums)):
        total += nums[i]
    total -= max(nums)
    total -= min(nums)
    return total / (len(nums) - 2)

def sum13(nums):
    total = 0
    i = 0
    while i < len(nums):
        if nums[i] == 13:
            i += 2
            continue
        total += nums[i]
        i += 1
    return total

def sum67(nums):
    total = 0
    i = 0
    while i < len(nums):
        if nums[i] == 6:
            while nums[i] != 7:
                i += 1
            i += 1
            continue
        total += nums[i]
        i += 1
    return total

def has22(nums):
    for i in range(0, len(nums) - 1):
        if nums[i] == 2 and nums[i + 1] == 2:
            return True
    return False