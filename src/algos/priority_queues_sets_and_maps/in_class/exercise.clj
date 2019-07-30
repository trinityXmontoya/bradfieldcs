;1. Understand the problem:
; Each of K servers returns N sorted results. When aggregating the results on your side, how do you preserve their sorted order?
; Assumptions -> we have access to all N results from the servers at the same time. size of N is consistent across all K servers.
;
;2. Devise a plan
; We've read/talked about a few structures in the context of ordered elements: ordered lists, stacks/queues/dequeues, binary heaps
;
; BINARY HEAP FROM ARRAY
; Building a binary heap from an array of N items is O(N). We could add all N items from K servers into one array
; and then build a binary heap from that array.
; Performance:
; O(N) -> build array
; O(N) -> build binary heap from ^ array
;
; MERGE SMALLER BINARY HEAPS
; I wondered if there was any benefit to storing each array of results as a binary heap and then merging those heaps. That would be
; O(N)   * K       ->   building a binary heap * K servers
; O(N+M) * K - 1 -> merging two heaps *  number of times we'll have to merge
;
; QUEUES
; Another more complex approach that doesn't require creating an intermediate array would be to create a queue for each
; server's results and then `peek` at each queue, `pop` the highest of all, and continue until all queues are empty.
; O(N) * K                ->  building a queue * K servers
; O(1) * ((K(K+1)/2) * N) -> peek * (sum of 0..K * N)
; O(1) * N                -> pop * N times
; O(1) * N                -> append N items to final data structure (in this case, an array)
;
; SORTING
; very similar to ^, instead of creating any intermediate data structures at all, i could just take the structures the results
; of the K servers are each stored in (ex Linked List) and compare the first element of each one, removing and adding to
; the final array as needed.