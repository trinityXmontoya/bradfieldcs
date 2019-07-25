1. Hashing and binary search both address the same problem: finding an item in a collection. What are some trade-offs between the two strategies? When might you want to pick one over the other?

- Performance tradeoff: What are you optimizing for?
    - Searching through a hash is O(1) while binary search is O(log N).
    - Deleting or updating elements in a sorted array is O(N) vs O(1) for a hash
- Complexity tradeoff: Implementing binary search is more straightforward than the process of choosing an appropriate hashing function and then dealing with collisions, deletions, etc.
- Data: Binary search makes sense for sortable items whereas hashing is a way to enforce an indexing strategy on items that don't otherwise have it (ex. what is the 'order' of a Person object?). 




2. If sorting takes (at minimum) O(n log n) time, and binary search takes O(log n) time, under what circumstances might it worth it to sort a collection in order to perform binary search?

If you plan to search the collection often and it is large enough to warrant implementing binary search ->

Sequential search takes worst-case O(N) time. If N is large enough, and you are frequently searching through it, taking the time to sort, and then implement binary search and achieve O(log N) on each subsequent search would be worth it. 

Or put another way "we cut the search space in half at each step rather than reducing it by one." (src: https://reprog.wordpress.com/2010/04/25/writing-correct-code-part-1-invariants-binary-search-part-4a/)