#!/bin/bash

PYTHON="python3"

for i in tests/*; do
	echo "*** $i ***"
	$PYTHON minesweeper.py < $i;
done
