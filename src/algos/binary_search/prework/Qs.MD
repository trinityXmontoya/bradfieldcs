1. Hashing and binary search both address the same problem: finding an item in a collection. What are some trade-offs between the two strategies? When might you want to pick one over the other?





2. If sorting takes (at minimum) O(n log n) time, and binary search takes O(log n) time, under what circumstances might it worth it to sort a collection in order to perform binary search?

If you plan to search the collection often and it is large enough to warrant implementing binary search ->

Sequential search takes worst-case O(N) time. If N is large enough, and you are frequently searching through it, taking the time to sort, and then implement binary search and achieve O(log N) on each subsequent search would be worth it. 