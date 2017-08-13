Matrix building
- Matlab's power comes from its ability to manipulate matrices

a11 a12 .. a1n

a21 a22 .. a2n

..  ..	.. ..

am1 am2 .. amn

- Where m is the number of rows
- and n is the number of columns

- A m x 1 matrix is a column vector
- A n x 1 matrix is a row vector
- We use matrices occasionally to describe a point's location

- Say we have four points:
(0, 0), (2, 3), (-3, 1), (-1.5, -2.5)
- To organize these points we write a matrix to represent them, the matrix will
have the form of [x y]:

-3    1
 0    0
-3    1
-1.5 -2.5

- We can also represent a series of 3D points with a matrix that has the form of
[x y z]:

1 2 3
4 5 6
7 8 9

Creating Matrices
- To create a matrix in Matlab, we use [ and ]:
- Each element is separated by a comma
- Each row is separated from by a semicolon ";"

[1, 2, 3; 4, 5, 6; 7, 8, 9]

ans =

1 2 3
4 5 6
7 8 9

- The ":" colon operator allows quick construction of a matrix

a = 1:10

a = 

1 2 3 4 5 6 7 8 9 10

b = [1:5; 2:6]

b =

1 2 3 4 5
2 3 4 5 6

- To change these single digit increments we use the form:

start: increment :end

Example:
a = 10:-1: 1
a = 
10 9 8 7 6 5 4 3 2 1 

- To concatenate additional values in an existing matrix we use:
[]

Example:
a = [1 2]

[a, 3, 4]

a = 
1 2 3 4

or
[a; 3 4]

a =
1 2
3 4

Generating special matrices
- ones(m, n)

Example:

ones(3, 2)

ans =
1 1
1 1
1 1

- zeros(m, n)

Example:

zeros(2, 4)

ans =
0 0 0 0
0 0 0 0

- rand(m, n), generates random elements from 0 to 1

Example:

rand(2, 2)

ans = 
0.81 0.123
0.23 0.245

Accessing Elements Within a Matrix
- To access a matrix element, we use (m, n) to enter its row and column number

Example:

a = [1, 2, 3; 4, 5, 6]

a(1, 3)
ans =
3

- NOTE: Matlab starts index counting at 1, NOT 0

- For all values in a specific row
a(row#,:)

- For all values in a specific column

a(:, column#)

***
Matrix Calculations and Operations

Matrix Transpose
- To transpose a matrix is to convert its rows into columns and columns into rows
- We use the transpose function or the (') operator

Example:

a = [2, 3, 4:4, 5, 6]

transpose(a)

ans = 
2 4
3 5
4 6

a'

ans = 
2 4
3 5
4 6

Matrix Addition, Subtraction

- Remember, two matrices can be added or subtracted from each other if they are the
same size or dimension

Matrix Multiplication

- Given matrix A of size m x n and matrix B of size n x p, to compute A * B we multiply 
each element in a row by the corresponding elements in a column of B and add the sum

A =
a b
c d

B =
e f
g h

A*B =
ae + bg  af + bh
ce + dg  cf + dh


