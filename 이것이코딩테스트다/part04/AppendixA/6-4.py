from bisect import bisect_left, bisect_right

a = [1, 2, 3, 4, 6, 7, 9]
x = 3

print(bisect_left(a, x))
print(bisect_right(a, x))