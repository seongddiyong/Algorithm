from sys import stdin
input = stdin.readline
a = [int(input()) for _ in range(3)]
b = [int(input()) for _ in range(2)]
print(min(a) + min(b) - 50)