P - can it be evaluated in polynomial time
ex. sort


Nondeterministic polynomial == can verify in polynomial time

NP hard (if u solve u can solve any other NP problem)
vs
NP complete (reduce any NP problem to it, and is NP)


sorting cant be solved in linear time,
but by using sorting u can solve something in linear time

P - can solve quickly
NP - can verify quickly
NP hard -> hammer to solve all NP problems
NP complete -> NP hard and NP

Qs:
- distinction between solve & verify
- would you implement a queue using a map
- can u join in constant time


Consider two implementations of the queue abstract data type, one implemented using a dynamic array and the other as a doubly linked list. What is the Big O complexity of the push and pop operations? Other than Big O complexity, can you think of any potential performance differences between the two?

catcow
push -> doubly linked list -> traversal to get to end

pop -> O(1)

