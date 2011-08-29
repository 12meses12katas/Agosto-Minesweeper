#!/usr/bin/env python3


def parseLine(c):
	"""	Auxiliar function used for mapping input characters"""

	if c == '*':
		return '*'
	else:
		return 0

def inc(vector, y, x):
	"""	Add 1 to vector[y][x] (amount of adjacent mines),
	if it's not a mine itself"""

	try:
		vector[y][x] += 1
	except IndexError:	# last vector / position
		pass
	except TypeError:	# trying to increment a mine ('*', char type)
		pass

def bombIn(field, x, y):
	"""	Process a mine at position (x,y)"""

	inc(field, y, x+1)
	inc(field, y+1, x)
	inc(field, y+1, x+1)

	# This comprobations are made because in python, vector[-1] never throws an
	# IndexError (except if vector is empty), instead it returns the last
	# element from the list
	if x != 0 and y != 0:
		inc(field, y-1, x-1)
	if x != 0:
		inc(field, y+1, x-1)
		inc(field, y, x-1)
	if y != 0:
		inc(field, y-1, x)
		inc(field, y-1, x+1)

def main():
	"""	Entry point"""

	# Container of all input fields
	fields = []

	# Parse and save all fields
	nofields = 0
	line = input()

	while line != "0 0" and line != "":
		dim = line.split(" ")
		fields.append([])
		for i in range(int(dim[0])):
			fields[nofields].append(list(
					map(  parseLine, list(input())[:int(dim[1])]  )))
		nofields += 1
		line = input()

	# Process adjacent mines
	x = y = 0
	for fieldno in range(nofields):
		y = 0
		for line in fields[fieldno]:
			x = 0
			for pos in line:
				if pos == '*':
					bombIn(fields[fieldno], x, y)
				x += 1
			y += 1

	# Print fields
	for fieldno in range(nofields):
		print("Field #{0}".format(fieldno+1))
		for line in fields[fieldno]:
			print("".join([str(x) for x in line]))
		print

if __name__ == "__main__":
	main()
