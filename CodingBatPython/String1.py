def hello_name(name):
    return "Hello " + name + "!"

def make_abba(a, b):
    return a + b + b + a

def make_tags(tag, word):
    return "<" + tag + ">" + word + "</" + tag + ">"

def make_out_word(out, word):
    return out[0] + out[1] + word + out[2] + out[3]

def extra_end(str):
    return 3 * (str[-2] + str[-1])

def first_two(str):
    if len(str) > 2:
        return str[0] + str[1]
    return str

def first_half(str):
    return str[0 : len(str) / 2]

def without_end(str):
    return str[1:-1]

def combo_string(a, b):
    if len(a) > len(b):
        return b + a + b
    return a + b + a

def non_start(a, b):
    return a[1:] + b[1:]

def left2(str):
    return str[2:] + str[0:2]