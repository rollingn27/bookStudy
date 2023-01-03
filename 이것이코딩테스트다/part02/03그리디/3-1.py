# 거스름돈, 동전 수
n = 1260
count = 0

# 큰 단위의 화페로부터 차례대로 확인
coin_types = [500, 100, 50, 10]

# 동전 수 세기
for coin in coin_types:
  count += n // coin
  n %= coin

print(count)