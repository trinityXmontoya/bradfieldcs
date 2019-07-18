*What are the trade-offs being made between chaining and linear probing?*

With chaining you avoiding clustering + having to search the entire table for an open spot -> O(table size), in exchange you
have the potential of O(chain size) when looking for an element.
There are ways to avoid clustering being *as bad* with linear probing by using a different strategy (ex. quadratic probing).
I also wonder what happens when a list filled by linear probing becomes full? (it's duplicated!! src: https://en.wikipedia.org/wiki/Open_addressing#Example_pseudocode, Note 1)

From the [Ruby discussion](https://bugs.ruby-lang.org/issues/12142) on switching from chaining to linear probing, linear probing:
- reduces 'pointer chasing' which is ["a common sequence of instructions that involves a repeated series of irregular memory access patterns that require the accessed data to determine the subsequent pointer address to be accessed"](https://en.wikichip.org/wiki/pointer_chasing).
- *should* reduce memory usage because computers cache information in physically close locations (i.e. spatial locality)
but there is debate in this thread about this specific implementation actually reducing memory?

*Considering a hash map that uses chaining, when should the underlying array grow?*

It never has to! But, each element has the potential to spin an infinite Linked List out of it. And according to [this](https://www.geeksforgeeks.org/hashing-set-3-open-addressing/)
it can also leaded to 'wasted' space because some slots are never filled vs open addressing can fill slots that that may
not have otherwise been returned by the hashing function.

*What about for one that uses linear probing?*

Once it's filled! The new array is allocated exponentially more space to reduce frequency of having to do this.

*Which of these do you think is more commonly used?*

Open addressing is better when you know the size of the data yr working with because you
won't have to worry about following separate chains or duplicating the entire table, and lookup is O(N). There's
increased complexity with choosing a hashing function that will best avoid clustering and some more complexity on how to
handle [deletion](https://news.ycombinator.com/item?id=19444803).

Chaining is better if the size of the data set is unknown/dynamic because you have 'infinite' space to expand w/o having
to worry about ^ concerns. Searching in the chain is O(M) where M is the chain size, which could be larger than the underlying
array itself.
