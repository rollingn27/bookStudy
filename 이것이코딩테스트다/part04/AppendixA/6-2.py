from itertools import permutations
from itertools import combinations
from itertools import product
from itertools import combinations_with_replacement

data = ['A', 'B', 'C']

result = list(permutations(data, 3))
print(result)

# 순서에 상관없음
result = list(combinations(data, 2))
print(result)

# 2개를 뽑는 모든 순열 구하기(중복 허용)
result = list(product(data, repeat=2))
print(result)

# 2개를 뽑는 모든 조합 구하기(중복 허용)
result = list(combinations_with_replacement(data, 2))
print(result)