def cigar_party(cigars, is_weekend):
    # cigars between 40 and 60
    # if weekend - no upper bound
    if cigars < 40:
        return False
    if is_weekend or cigars <= 60:
        return True
    return False

def date_fashion(you, date):
    if you <= 2 or date <= 2:
        return 0
    if you >= 8 or date >= 8:
        return 2
    return 1

def squirrel_play(temp, is_summer):
    # play if temp between 60 - 90
    # if summer, upper is 100
    if temp < 60:
        return False
    return (temp <= 90 and not is_summer) or (temp <= 100 and is_summer)

def caught_speeding(speed, is_birthday):
    if not is_birthday:
        if speed <= 60:
            return 0
        if speed <= 80:
            return 1
        return 2
    if speed <= 65:
        return 0
    if speed <= 85:
        return 1
    return 2

def sorta_sum(a, b):
    if a + b < 10 or a + b > 19:
        return a + b
    return 20

def alarm_clock(day, vacation):
    # not vacation + weekday = 7:00
    # not vacation + weekend = 10:00
    # vacation + weekday = 10:00
    # vacation + weekend = off
    if not vacation and day != 0 and day != 6:
        return "7:00"
    if vacation and (day == 0 or day == 6):
        return "off"
    return "10:00"

def love6(a, b):
    if a == 6 or b == 6:
        return True
    if a + b == 6 or abs(a - b) == 6:
        return True
    return False

def in1to10(n, outside_mode):
    if outside_mode:
        return n <= 1 or n >= 10
    return 1 <= n <= 10

def near_ten(num):
    return abs(num % 10) <= 2 or abs(num % 10) >= 8


