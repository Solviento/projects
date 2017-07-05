# midterm-notes
Matrix Multiplication
Takes O(n^3)

```java
SquareMatrix(array A, array B):
    int n = A.length
    C = new n x n matrix
    for (int i = 0 to n){
        for (int j = 0 to n){
            C[i][j] = 0
            for (int k = 0 to n){
                C[i][j] = C[i][j] + A[i][k] * B[k][j]
            }
        }
    }
```
Strassen Matrix Multiplication
Takes O(n^2.81) or O(n^log7)
- Creates 7 new products using subarrays in the two matrices (AHED, ABA)
- 


Maximum Subarray Problem
Worst case: n log n
We seek to find an interval in which a maximum subarray can be found


Solving Recurrences
A recurrence is an equation that describes a function in terms of its value on smaller inputs. To solve recurrences we use:
- Substitution Method
  - We guess a bound and then use mathematical induction to find the constraints and prove our solution works
- Iteration Method
  - Expand the recurrence (by converting recurrence into a tree whose nodes represent the costs incurred at various levels)
  - Work some algebra to express as a summation
  - Evaluate the summation
  - T(n) =
    - { c for n = 1}
    - {a T(n/b) + cn for n > 1}
      - O(nlog(n)) for a = b
      - O(n) for a < b
      - O(n log a) for a > b
- Master Method
  - Given a divide and conquer algorithm, master theorem gives a cookbook for the algorithm's running time
  - if T(n) = a T(n/b) + f(n) then
    - Using a, b to form n^(log_b a), we compare it against f(n)
      - If f(n) < n^(log_b a) 
        - Then T(n) = O(n^(log_b a))
      - If f(n) = n^(log_b a) 
        - Then T(n) = O(n^(log_b a) log(n) 
      - If f(n) > n^(log_b a) 
        - Then T(n) = O( f(n))
  - Master theorem does not work when f(n) = log n or sin(n) or 2^n
  - Another take on Master Theorem (easier to understand)
    - If f(n) = O(n^d)
      - T(n) = O(n^d) for a < b^d
      - T(n) = O(n^d log n) for a = b^d
      - T(n) = O(n^(log_b a)) for a > b^d
Asymptotic Notations
- o() is like <
- O() is like <= 
- ω() is like >
- Ω() is like >=
- Θ() is like =


Insertion Sort
Worst case: n^2
- Why?
  - The summation of insertion sort's cost is n(n-1)/2 = n^2

```java
InsertionSort(array A):
    for (int j = 1 to A.length){
        key = A[j]
        int i = j - 1        // insert A[j] into the sorted sequence of A[1..j-1]
        while (i > 0 and A[i] > key){
                A[i+1] = A[i]
                i = i-1
        }
        A[i+1] = key
```


Merge Sort
Worst case: nlog(n)
- Why? 
  - Its recursion tree has log(n) + 1 levels where each level costs cn for a total cost of cn(log(n) + 1) = nlog(n)
- Divide the n-element sequence to be sorted into two subsequences of n/2 elements each
- Sort the two subsequences recursively using merge sort
- Merge the two sorted subsequences to produce the sorted answer
The recursion bottoms out when the sequence to be sorted has length 1

```java
// merges A[p..q] with A[q+1..r]
Merge(array A, int p, int q, int r):
    // p, q, r are indices into the array such that p <= q < r
    array B[p..r]
    int i, k = p            // initalize pointers
    int j = q+1    
    // while both subarrays are nonempty    
    while (i <= q and j <= r){    //  // copy from left subarray
        if(A[i] <= A[j] {        
                B[k++] = A[i++]   
        else{                     // copy from right subarray
                B[k++] = A[j++]   
        }
    // copy leftover to B
    while (i <= q){
        B[k++] = A[i++]
        B[k++] = A[j++]
    }
    for (i = p to r){
        A[i] = B[i]
    }
MergeSort(array A, int p, int r):
    if (p < r){
        q = (p+r)/2
        MergeSort(A, p, q)        // sort A[p..q]
        MergeSort(A, q+1, r)      // sort(A[q+1..r]
        Merge(A, p, q, r)         // merge everything
    }
```


Divide Conquer Combine
- Divide the problem into a number of subproblems that are smaller instances of the same problem
- Conquer the subproblems by solving them recursively. If the subproblem sizes are small enough, however, just solve the subproblems in a straightforward manner
- Combine the solutions to the subproblems into the solution for the original problem


Heapsort
To represent a Complete Binary Tree as an array
- root node is A[0]
- Node i is A[i]
- Parent of node i is A[i/2] 
- Left child of node i is A[2i]
- Right child of node i is A[2i+1]
For this section, we discuss Max Heaps
Heap Property
- The value of a node is AT MOST the value of its parent

```java
// maintain heap property
Heapify(array A, int i):
// given a node i in the heap w childrean l and r
    l = Left(i);    // see above
    r = Right(i);   // see above
    if (l <= heapsize(A) && A[l] > A[i]){
        largest = l
    }
    else{
        largest = i;
    }
    if (r <= heap_size(A) && A[r] > A([largest]){
        largest = r;
    }
    if (largest != r){
        Swap(A, i, largest);
        Heapify(A, largest);
    }    
```




































