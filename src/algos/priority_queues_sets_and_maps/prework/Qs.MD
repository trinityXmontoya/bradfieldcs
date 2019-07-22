*What are the trade-offs being made between chaining and linear probing?*

With chaining you avoiding clustering + having to search the entire table for an open spot -> O(table size), in exchange you
have the potential of O(chain size) when looking for an element.
There are ways to avoid clustering being *as bad* with linear probing by using a different strategy (ex. quadratic probing).
I also wonder what happens when a list filled by linear probing becomes full? (it's duplicated!! src: https://en.wikipedia.org/wiki/Open_addressing#Example_pseudocode, Note 1)

From the [Ruby discussion](https://bugs.ruby-lang.org/issues/12142) on switching from chaining to linear probing, linear probing:
- reduces 'pointer chasing' which is ["a common sequence of instructions that involves a repeated series of irregular memory access patterns that require the accessed data to determine the subsequent pointer address to be accessed"](https://en.wikichip.org/wiki/pointer_chasing). 
- relatedly, *should* reduce memory usage. In an array, each index is *physically adjacent*. Contrast this with a linked list where ["each new node is given a location at the time of its creation. This new node is not necessarily physically adjacent to its neighbors in the list. The result is that in a linked list nodes that are “next to each other” in the list order are rarely physically next to each other in terms of the actual location inside our RAM chip.](https://blog.bradfieldcs.com/an-introduction-to-hashing-in-the-era-of-machine-learning-6039394549b0) Computers cache information that is in physically close locations (i.e. spatial locality) and since linear probing is implemented with arrays it can benefit from this caching.
(but there is debate in this thread about this specific implementation actually reducing memory?)

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

Other notes:

[Cuckoo hashing](https://en.wikipedia.org/wiki/Cuckoo_hashing) is a method for avoiding hash collisions by providing two hashing functions for an element so it has more than one spot it can fill. If you attempt to add an element to an occupied spot, the *current* item is 'kicked out' and processed on the next round of insertion. In theory it provides constant time lookup but in practice it's slower than linear probing because it [causes two cache misses per search](https://en.wikipedia.org/wiki/Cuckoo_hashing#Practice).
Also, Inserting items needs to be atomic (as you can imagine because you can't have different threads kicking out different items that have just been inserted) and is therefore not parallelizable (src: https://www.youtube.com/watch?v=47skwt4njTc)