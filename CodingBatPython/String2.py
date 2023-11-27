def double_char(str):
    string = ""
    for i in range(0, len(str)):
        string += str[i]
        string += str[i]
    return string

def count_hi(str):
    count = 0
    for i in range(0, len(str) - 1):
        if str[i : i + 2] == "hi":
            count += 1
    return count

def cat_dog(str):
    cat = 0
    dog = 0
    for i in range(0, len(str) - 2):
        if str[i : i + 3] == "cat":
            cat += 1
        if str[i : i + 3] == "dog":
            dog += 1
    return cat == dog

def count_code(str):
    count = 0
    for i in range(0, len(str) - 3):
        if str[i : i + 2] == "co" and str[i + 3] == "e":
            count += 1
    return count


# noinspection GrazieInspection
def end_other(a, b):
    # check if a is shorter than b
    if b[-1 * len(a):].lower() == a.lower():
        return True
    if a[-1 * len(b):].lower() == b.lower():
        return True
    return False

def xyz_there(str):
    if str[0 : 3] == "xyz":
        return True
    for i in range(0, len(str) - 3):
        if str[i + 1 : i + 4] == "xyz" and str[i] != ".":
            return True
    return False
