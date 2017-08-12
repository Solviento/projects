Making a diary

What is a diary?
- We can save all commands entered in the command window into a text file (a diary)
- To start recording:
diary diary_name
- To stop recording:
diary off

Making a data file

What is a data file?
- We can save all used variables in the workspace for future use
- This is useful for when taking a break or importing someone else's data
- Save all variables:
save datafile_name
- The data will be saved into datafile_name.mat file
- To load a data file into Matlab:
load datafile_name
- or click and drag the .mat file into the command window

Making a script

- We use scripts when it becomes tedious to use the same commands and expressions
over and over again
- Matlab can save a list of commands into a script file, which is then executed
by calling its name
- To create a script file:
edit script_name
- Click yes
- Enter commands and save the file
- To run the script:
script_name
- or click and drag the script_name.m file into the command window

Example of script saving and execution:
x = 5
y = 5
edit script1
...
sum = x + y
difference = x - y
product = x * y
quotient = x / y
...
script1

Comments
- Matlab comments begin with %
- Anything after % will be ignored

Functions
- To create function we enter:
edit function_name
- First line of function must begin with the line template:
function output = function_name(input)
- To run function enter:
function_name(input)

Example of creating a function:
edit my_squareroot
...
function y = my_squareroot(x)
y = x^(1/2)

- We can call our function in the command window by:
my_squareroot(9)

ans = 3


