max = " "
def check_uniqueness(strng):
    flag = 0
    for char in strng:
        n = 0
        for char2 in strng:
            if char == char2:
                n = n + 1
        if n > 1:
            flag = 1
            break
    return flag

def check_length(strng):
    return len(strng)

if __name__ == '__main__':
    #All possible combinations of words from a string
    strng = input('Enter a string : ')
    for i in range((len(strng)+1)):
        for j in range((len(strng)+1)):
            a_p_s = (strng[i:j])#a_p_s stands for all possible substrings
            isunique = check_uniqueness(a_p_s)
            if isunique == 0:
                len1 = check_length(a_p_s)
                len2 = len(max)
                if len1 > len2:
                    max = a_p_s
    print("The max substring is : ",max)