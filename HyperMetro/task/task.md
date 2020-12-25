##Stage 1/6: One-line metro
###Description
Imagine you work for the metro system and your task is to develop a program that displays all the stations of the current line. At this point, let's assume that the metro has only one line.

The stations were built one by one, which is similar to a data structure called a **linked list**. At first sight, a linked list seems very similar to an array, but it actually has some important advantages over arrays. For example, the array length is fixed, so when you add a new element, a new memory area is allocated for the modified array, which isn't good for the program performance. In a linked list, on the other hand, the elements are scattered throughout the memory and connected to each other by special links.

In this stage, we will use a **singly-linked list**. In this data structure, each element of the list stores its data together with a pointer to the next element. Basically, the first element is a "head" and the last one is a "tail". The "tail" element stores a pointer to null, which signifies the end of the linked list.

###Objective
You have a simple text file with the information about the names of the stations. The path to the file is specified by the common line argument. Your program should read the file, generate a singly-linked list of the stations, and print them like this:

```
depot - Station 1 - Station 2
Station 1 - Station 2 - Station 3
Station 2 - Station 3 - Station 4
...
Station (n-1) - Station n - depot
```
The end of the linked list is the `depot`.

If the file is empty, do not print anything, and if the path to the file is invalid, print an error message.

For your simple metro map, you may use the stations of [Baltimore Subway](https://en.wikipedia.org/wiki/Baltimore_Metro_SubwayLink):

```
Owings Mills
Old Court
Milford Mill
Reiserstown Plaza
Rogers Avenue
West Cold Spring
Mondawmin
Penn North
Uptown
State Center
Lexington Market
Charles Center
Shot Tower/Market Place
Johns Hopkins Hospital
```
###Example
####Input file:

```
Bishops road
Edgver road
Baker street
Portland road
Gower street
Kings cross
Farringdon street
```
####Example of running the program:

`java Main example-file.txt`
####Output:

```
depot - Bishops road - Edgver road
Bishops road - Edgver road - Baker street
Edgver road - Baker street - Portland road
Baker street - Portland road - Gower street
Portland road - Gower street - Kings cross
Gower street - Kings cross - Farringdon street
Kings cross - Farringdon street - depot
```