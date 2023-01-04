# 이진 탐색 재귀적으로 구현
def binary_search(array, target, start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  # 찾은 경우 반환
  if array[mid] == target:
    return mid
  elif array[mid] > target:
    return binary_search(array, target, start, mid - 1)
  else:
    return binary_search(array, target, mid + 1, end)

# n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
n, target = map(int, input().split())

# 전체 원소 입력받기
array = list(map(int, input().split()))

# 이진 탐색 수행 결과 출석
result = binary_search(array, target, 0, n - 1)
if result == None:
  print("원소가 존재하지 않습니다.")
else:
  print(result + 1)