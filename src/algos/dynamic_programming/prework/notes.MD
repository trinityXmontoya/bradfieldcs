# Dynamic Programming

"Dynamic programming is a method to solve certain classes of problems by solving recurrence relations/recursion and storing previously found solutions via either tabulation or memoization."


1. In what scenarios can it be beneficial to apply dynamic programming?

If you know that you can divide the problem into smaller subproblems in which solving the 'next' iteration requires computations from the previous iteration.

Ex, to calculate the  3rd fibonacci number, you have to add the result of the 2nd and the 1st. if you did this recursively then solving just for the 3rd would duplicate work done when calculating the 2nd and the 1st.


2. What are the differences between the memoization (top-down) and tabulation (bottom-up) approaches?

With tabulation, you are starting from the 'bottom' and iteratively storing each value. For example, to calculate the 3rd fibonacci number, you start at the 'bottom' (0) and store `fib(0)`, `fib(1)`, and `fib(2)`. Then you can access the result of `fib(2)`. With memoization, you only store a value if it's actually needed so `fib(2)` would call `fib(2)` directly (which subsequently calls `fib(1)` and `fib(0)`, but only because it *requires* them).

"If the original problem requires all subproblems to be solved, tabulation usually outperformes memoization by a constant factor. This is because tabulation has no overhead for recursion and can use a preallocated array rather than a hash map.
 
 If only some of the subproblems needs to be solved for the original problem to be solved, then memoization is preferrable since the subproblems are solved lazily, i.e. precisely the computations needed are carried out."
(src:https://programming.guide/dynamic-programming-vs-memoization-vs-tabulation.html)

3. Is there a relationship between the parameters of a recursive function and the corresponding memo table? What about between the time and space complexities of a top-down approach?

I'm not sure how to approach the first question.

w/r/t the second, the block above answers it:
Assuming the given problem must be solved by calculating every subproblem, the top-down approach takes up more memory because
it uses a hash map rather than an array (so it's size will grow dynamically over time).
Assuming the given problem can be solved *without* calculating every subproblem, the top-down approach takes less time because
it only calculates the values it needs to.
