# sorting-algorithms
**Insertion sort**
Insertion sort compares and swaps elements by iteration. We start by selecting the first element, append it to the sorted subarray and then compare the next available unsorted element with all preceding sorted elements.


Best case: O(n) ie. a presorted list
Average/Worst case: O(n^2)


An unsorted array:

```java
23 42 4 16 8 15
```
append 23 to sorted subarray

```java
sorted    unsorted
23 | 42 4 16 8 15
```
compare 42 and 23
23 < 42 so we insert it to the right

```java
sorted    unsorted
23 42 | 4 16 8 15
```
compare 4 and 42
4 < 42 so we insert it and shift 42 to the right
compare 4 and 23
4 < 23 so we insert it and shift 23 to the right

```java
sorted    unsorted
4 23 42 | 16 8 15
```
compare 16 and 42 ...
compare 16 and 23 ...
compare 16 and 4
16 > 4 so we insert it and shift 23 to the right

```java
sorted    unsorted
4 16 23 42 | 8 15
```
compare 8 and 42 ...
compare 8 and 23 ...
compare 8 and 16 ...
compare 8 and 4
8 > 4 so we insert it and shift 23 to the right

```java
sorted        unsorted
4 8 16 23 42 | 15
```
compare 15 and 42 ...
compare 15 and 23 ...
compare 15 and 16 ...
compare 15 and 8
15 > 8, insert and shift 16 to the right

```java
sorted
4 8 15 16 23 42
```
Insertion sort pseudo code:

```java
function insertionSort(array a)
    for i in 0 -> (a.length - 2):
       tmp = a[i]
       j = i+1
        while (j > 0 and a[j-1] < tmp)
                array[j] = array[j-1]
                j = j-1 // or j--;
    a[j] = tmp
```


**Merge sort**
Divide and conquer algorithm.


Best/Average/Worst case: O((nlogn)


An unsorted array:

```java
9 2 6 5 3 10 1 7
```
separate all elements into subarrays of 1 element each

```java
9 | 2 | 6 | 5 | 3 | 10 | 1 | 7
```
then compare each sequential subarray pair and merge accordingly

```java
9 | 2 ...
```
2 < 9, shift 9 and merge

```java
2 9 | 6 | 5 | 3 | 10 | 1 | 7
```
next subarray pair

```java
... 6 | 5 ...
```
5 < 6, shift 6 and merge

```java
2 9 | 5 6 | 3 | 10 | 1 | 7
```
next subarray pair

```java
... 3 | 10 ...
```
10 > 3, merge

```java
2 9 | 5 6 | 3 10 | 1 | 7
```
...

```java
2 9 | 5 6 | 3 10 | 1 7
```
now compare each sequential subarray pairs and merge accordingly

```java
2 9 | 5 6 ...
```
2 < 5, merge 2 to itself

```java
2 | 9 | 5 6 ...
```
9 > 5,merge 5 to the right of 2

```java
2 5 | 9 | 6 ...
```
9 > 6, shift 9 and merge 6 to the right of 5

```java
2 5 6 | 9 ...
```
no more additional elements, merge 9 to the right of 6
move to next pair

```java
... 3 10 | 1 7
```
3 < 1, merge 1 to itself

```java
... 1 | 3 10 | 7
```
7 > 3, merge 3 to the right of 1

```java
... 1 3 | 7 | 10
```
7 < 10, merge 10 to the right of 3

```java
... 1 3 7 | 10
```
no more element to compare, merge 10 to the right of 7

```java
... 1 3 7 10
```
now we compare the subarray pairs and merge accordingly

```java
2 5 6 9 | 1 3 7 10
```
1 < 2, merge 1 to itself

```java
1 | 2 5 6 9 | 3 7 10
```
2 < 3, merge 2 to the right of 1

```java
1 2 | 5 6 9 | 3 7 10
```
3 < 5, merge 3 to the right of 2

```java
1 2 3 | 5 6 9 | 7 10
```
5 < 7, merge 5 to the right of 3

```java
1 2 3 5 | 6 9 | 7 10
```
7 > 6, merge 6 to right of 5

```java
1 2 3 5 6 | 9 | 7 10
```
...

```java
sorted
1 2 3 5 6 7 9 10
```
Pseudocode

```java
mergeSort(array, first, last):
    //sort array[first] to array[last-1]
    if last-first <= 1:
        return // single/non-element or already sorted
    mid = (first+last)/2
    mergeSort(array, first, mid)    // recursively
    mergeSort(array, mid, last)     // loops
    merge(array, first, mid, last)  // merges at sort
```
**Heapsort**
Create a max heap from an array. Use the max heap's properties to sort.


Best/Average/Worst case: O(nlogn)


unsorted array

```java
41 67 34 0 69 24 78 58 62 64 5 45 81 27 61
```
preview of max heap array

```java
81 67 78 62 64 69 61 0 58 41 24 45 27 34
...
          81
          |   
    67          78
    |           |
 62    64     69    61
|  |  |  |   |  |  |  |
0 58  41 5  24  45 27 34
```
when told to sort in place, we percolate the elements as needed
start with first element of the array
construct the max heap in place
if max heap condition is violated, percolate elements until condition is met

```java
41 67 34 0 69 24 78 58 62 64 5 45 81 27 61
^ 
```
no percolation

```java
41 67 34 0 69 24 78 58 62 64 5 45 81 27 61
^  ^^ ^^
```
41 < 67, condition violated
percolate

```java
67 41 34 0 69 24 78 58 62 64 5 45 81 27 61
^  ^^ ^^
```
no percolation

```java
67 41 34 0  69 24 78 58 62 64 5 45 81 27 61
   ^     ^^ ^^
```
41 < 69, condition violated
percolate

```java
67 69 34 0 41 24 78 58 62 64 5 45 81 27 61
^  ^^ ^^
```
67 < 69, condition violated
percolate

```java
69 67 34 0  41 24 78 58 62 64 5 45 81 27 61
   ^     ^^ ^^
```
no condition violated, proceed

```java
69 67 34 0 41 24 78 58 62 64 5 45 81 27 61
      ^       ^^ ^^
```
34 < 78, condition violated
percolate

```java
69 67 78 0 41 24 34 58 62 64 5 45 81 27 61
^  ^^ ^^
```
69 < 78, condition violated
percolate

```java
78 67 69 0  41 24 34 58 62 64 5 45 81 27 61
   ^     ^^ ^^
      ^        ^^ ^^
```
no condition volated, proceed

```java
78 67 69 0  41 24 34 58 62 64 5 45 81 27 61
         ^           ^^ ^^
```
0 < 58, condition violated
percolate

```java
78 67 69 58 41 24 34 0 62 64 5 45 81 27 61
   ^     ^^ ^^
```
no condition violated

```java
78 67 69 58 41 24 34 0  62 64 5 45 81 27 61
         ^           ^^ ^^
```
58 < 62, condition violated
percolate

```java
78 67 69 62 41 24 34 0  58 64 5 45 81 27 61
   ^     ^^ ^^
      ^        ^^ ^^
         ^           ^^ ^^
```
no condition violated

```java
78 67 69 62 41 24 34 0 58 64 5 45 81 27 61
            ^             ^^ ^^
```
41 < 64, condition violated
percolate

```java
78 67 69 62 64 24 34 0  58 41 5  45 81 27 61
   ^     ^^ ^^
      ^        ^^ ^^
         ^           ^^ ^^
            ^              ^^ ^^
```
no condition violated, proceed

```java
78 67 69 62 64 24 34 0 58 41 5 45 81 27 61
               ^               ^^ ^^ 
```
24 < 45, condition violated
percolate

```java
78 67 69 62 64 45 34 0 58 41 5 24 81 27 61
               ^               ^^ ^^
```
45 < 81, condition violated
percolate

```java
78 67 69 62 64 81 34 0 58 41 5 24 45 27 61
      ^        ^^ ^^
```
69 < 81, condition violated
percolate

```java
78 67 81 62 64 69 34 0 58 41 5 24 45 27 61
^  ^^ ^^
```
78 < 81, condition violated
percolate

```java
81 67 78 62 64 69 34 0 58 41 5 24 45 27 61
...
                  ^                  ^^ ^^
```
34 < 61, condition violated
percolate

```java
81 67 78 62 64 69 61 0 58 41 5 24 45 27 34
```
we now have our max heap array
in order to sort, we must
swap the root node with the last element in the unsorted array
we percolate as needed if a condition is violated

```java
unsorted                                 sorted
34 67 78 62 64 69 61 0 58 41 5 24 45 27 | 81
```
many conditions violated, percolate until max heap attained

```java
unsorted                                 sorted
78 67 69 62 64 45 61 0 58 41 5 24 34 27 | 81
```
swap root node with last unsorted element

```java
unsorted                               sorted
27 67 69 62 64 45 61 0 58 41 5 24 34 | 78 81
```
percolate, swap, percolate until all elements are in the sorted array


Pseudocode

```java
Heapsort(array A)
    BuildHeap(A)
    for i = n to 1
        swap(A[1], A[i])
        n = n - 1
        Heapify(A, 1)

BuildHeap(array A)
    n = elements_in(A)
    for i = floor(n/2) to 1
        Heapify(A,i,n)

Heapify(array A, int i, int n)
    left = 2i
    right = 2i+1

    if (left <= n) and (A[left] > A[i])
        max = left
    else 
        max = i

    if (right<=n) and (A[right] > A[max])
        max = right

    if (max != i)
        swap(A[i], A[max])
        Heapify(A, max)
```
















































