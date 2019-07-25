(ns algos.binary_search.postwork.matrix)

; Search a 2D Matrix (src: https://leetcode.com/problems/search-a-2d-matrix/)
;Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
;- Integers in each row are sorted from left to right.
;- The first integer of each row is greater than the last integer of the previous row.

;1. Understand the problem
;
;Given a two dimensional array of M x N elements, return whether item X is present in any of the arrays
;Each internal array is sorted left to right. The first element of each internal array is greater than the last element
;of the previous array.
;Use binary search
;
;2. Devise a plan
; given the sorting we can immediately exit if:
;- the item is less than the first element of the first array
;- the item is greater than the last element of the last array
;
;3. Carry out the plan
(defn search-matrix
  [matrix item]


  )

;4. Look back