def solution(topping):
    answer = 0
    topping_set = set()
    topping_dict = {}
    
    for i in topping:
        str_i = str(i)
        topping_dict[str_i] = topping_dict.get(str_i, 0)
        topping_dict[str_i] += 1
        
    for i in topping:
        
        topping_set.add(i)
        
        str_i = str(i)
        topping_dict[str_i] -= 1
        if topping_dict[str_i] <= 0:
            del(topping_dict[str_i])
        
        set_len = len(topping_set)
        dict_len = len(topping_dict)
        
        if set_len > dict_len:
            break
        elif set_len == dict_len:
            answer += 1
    
    return answer
