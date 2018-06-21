How C++ Handles Pixel Arrays

* 0 1 2 3 4 5 6 7 8 9
0 - - - - - - - - - -
1 - - - - - - - - - - 
2 - - - - - - - - - -
3 - - - - - - - - - -
4 - - - - - - - - - - height h
5 - - - - - - - - - -
6 - - - - - - - - - -
7 - - - - - - - - - -
8 - - - - - - - - - -
9 - - - - - - - - - -
	  width w

Say we want to cover a 3x4 rectangle from upper right corner

Therefore:
7 <= x <= 9
0 <= y <= 2

Say we want a 4x5 rectangle that is 3 units from top, 4 units from right

Therefore (using h and w)
(w - (4 + 4) <= x <= (w - (4 + 1)) WE ADD +1 OFFSET DUE TO ARRAY CONVENTIONS

(0 + 3) <= y <= (0 + 3 + 5 - 1) WE ADD -1 OFFSET DUE TO ARRAY CONVENTIONS


