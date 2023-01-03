# n 배열의 크기
# m 숫자가 더해지는 회수
# k 연속 최대 회수
n, m, k = map(int, input().split())

# n개의 수를  공백으로 구분하여 입력받기
data = list(map(int, input().split()))

# 입력 받은 수 정렬
data.sort()

# 가장 큰 수와 두번째로 큰 수
first = data[n -1]
second = data[n -2]

# 덧셈 결과
result = 0

while True:  

  for i in range(k):
    if m == 0:
      break
    result += first
    m -= 1
  
  if m == 0:
    break
  result += second
  m -= 1

print(result)

