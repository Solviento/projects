Jason Perez
UNI: jp3476
HW 4

For these programs I used the Eclipse IDE, all input files were located in the
directory of homework folder, while the programs themselves were located in the
source folder inside the homework folder.

Important!!
When I downloaded the words.txt file, all words were formatted like so:

A
A's
AA's
AB's
ABM's
AC's
ACTH's
AI's
AIDS's .. etc.

In order to clarify any confusion, my program worked fine with the text format that was given above in canvas.


P1)
Files:
SpellChecker.java
words.txt
filetospellcheck.txt

In this programming assignment, my initial variables are int line, char[] alphabet,
and HashSet dictionary.

Constructor:
The SpellChecker constructor receives two Scanner objects, words and sampleWords.
Words being the dictionary text and sampleWords being the sample text to be corrected.
In order to extract all words from both files, I used separate while loops to
take each dictionary word into its own hashSet. Every word in the sample text
was extracted and formated to be tested for spelling. In hindsight, I believe
bufferedReader and StringTokenizer would provide faster run times. Once each word is extracted from the test file, I had it verified using the methods found below. If it were mispelled, all possible suggestions would be printed including the line it was found on.

printSuggestions:
Takes in 3 arrayLists for possible suggestions, will output a set of suggestions that contain no duplicates for each mispelled word. Will return an empty set if no suggestions are found.

SpellCheck:
Will check whether sample word is in the dictionary set. Return false if not in dictionary.

isInteger:
A modified version of an algorithm found on Stack Overflow. Since numbers are generally not mispelled, I needed a way to check whether the sample word was an integer. But I did not know the algorithm to test whether a string was an integer so I found a sample algorithm online and modified it to suit the program's purposes.

charAppend:
Appends any letter from a-z through all indices of the sample word string. Once all suggestions are found, they are inserted in an arrayList for further processing.

charDelete:
Will delete individual letters from the sample word to test for spelling suggestions. Uses stringBuilder to repeat spelling look up.

charSwap:
Will swap two adjacent letters in a string to check for spelling suggestions. Conversts the word String into a char array to perform swap implementation.

removeNon:
Removes all non-alphanumeric letters from front and back of the extracted sample word. Linan Qiu provided an example of this useful function on Canvas.

The main method takes in args[0] and args[0] from the command line and creates the SpellChecker object using those two arguments. Will throw and catch exception if file is not found.

Expected output:

Mispelled Word: mmost
LineNumber: 1
Suggestions: 
[most]
Mispelled Word: circulateds
LineNumber: 2
Suggestions: 
[circulates, circulated] ...

P2)
Files:
KBestCounter.java
TestKBest.java

In this programming assignment, my initial variables are int k, max_heap, heap_elements, list, k_largest. 

KBestCounter:
Constructor that initializes k with given integer. Also initializes a PriorityQueue object for max_heap (with a reverse natural order for Collections). A linked list is created to store heap element and an ArrayList to store largest k values in the heap.

count:
Simply adds a generic object to the max heap and heap elements structures.

kbest:
Resets k_largest array. Iterates through k to add max element in the heap to the arrayList. Once max heap is cleared through, we iterate through all heap elements and add them once more the max heap. We return the array of largest k values inserted.

Expected Output with tester file:

Inserting 1,2,3.
5-best should be [3,2,1]: [3, 2, 1, null, null]
Inserting another 2.
5-best should be [3,2,2,1]: [3, 2, 2, 1, null]



