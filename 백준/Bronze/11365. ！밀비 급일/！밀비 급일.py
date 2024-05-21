from sys import stdin
input = stdin.readline
while True:
	temp = input().rstrip()
	if temp == "END":
		break
	print(temp[::-1])