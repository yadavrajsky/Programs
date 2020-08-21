def Binary_To_Decimal_converter(binary_number):
    str_binary_number = str(binary_number)
    result = 0
    i = 0
    for j in str_binary_number[::-1]:
        result += (2**i) * int(j)
        i += 1
    return result


c = Binary_To_Decimal_converter(111100)
print(c)
