# 집합 자료형 초기화 방법 1
data = set([1, 1, 1, 2, 3, 4, 4, 5])
print(data)

# 집합 자료형 초기화 방법 1
data = {1, 2, 3, 4, 2, 2, 1, 1}
print(data)

a = set([1, 2, 3, 4, 5])
b = set([3, 4, 5, 6, 7])

# 합집합
print(a | b)
# 교집합
print(a & b)
# 차집합
print(a - b)

