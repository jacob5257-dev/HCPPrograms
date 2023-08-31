import math


def make_bricks(small, big, goal):
    return goal % 5 <= small and goal - big * 5 <= small

def lone_sum(a, b, c):
    total = 0
    if a != b and a != c:
        total += a
    if b != a and b != c:
        total += b
    if c != a and c != b:
        total += c
    return total

def lucky_sum(a, b, c):
    if a == 13:
        return 0
    if b == 13:
        return a
    if c == 13:
        return a + b
    return a + b + c

def no_teen_sum(a, b, c):
    return fix_teen(a) + fix_teen(b) + fix_teen(c)


def fix_teen(n):
    if 13 <= n <= 19 and n != 15 and n != 16:
        return 0
    return n

def round_sum(a, b, c):
    return round10(a) + round10(b) + round10(c)

def round10(num):
    if num % 10 < 5:
        return math.trunc(num / 10) * 10
    return math.trunc(num / 10) * 10 + 10

def close_far(a, b, c):
    return (abs(a - b) <= 1 and abs(a - c) >= 2 and abs(b - c) >= 2) or (abs(a - c) <= 1 and abs(a - b) >= 2 and abs(b - c) >= 2)

def make_chocolate(small, big, goal):
    big_bars = math.trunc(goal / 5)
    if big_bars <= big:
        goal -= big_bars * 5
    else:
        goal -= big * 5
    if goal <= small:
        return goal
    return -1
