# n 배열의 개수
# m 더해지는 수
# k 연속 최대 회수
n, m, k = map(int, input().split())

# n개의 수를 공백으로 입력받기
data = list(map(int, input().split()))

# 정렬 및 최대 수와 두번째 수
data.sort()
first = data[n - 1]
second = data[n - 2]

# 가장 큰 수가 더해지는 회수 계산
count = m // (k + 1) * k
count += m % (k + 1)

# 합의 결과
result = 0
result += count * first
result += (m - count) * second

print(result)