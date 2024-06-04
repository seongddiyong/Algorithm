from sys import stdin
input = stdin.readline
money, people = map(int, input().split())
print(money//people)
print(money%people)