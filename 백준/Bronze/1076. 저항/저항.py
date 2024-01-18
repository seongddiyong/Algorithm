d = {"black":0, "brown":1, "red":2, "orange":3, "yellow":4, "green":5, "blue":6, "violet":7, "grey":8, "white":9}
q = [d[input()] for _ in range(3)]
print((q[0]*10 + q[1]) * 10**q[2])