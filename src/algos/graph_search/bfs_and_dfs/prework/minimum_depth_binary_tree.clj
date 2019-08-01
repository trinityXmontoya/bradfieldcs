(ns algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree)

;1. Understand the problem
; (src: https://leetcode.com/problems/minimum-depth-of-binary-tree/description/)
;Given a binary tree, find its minimum depth.
;
;The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
;
;Note: A leaf is a node with no children.
;
;Example:
;
;Given binary tree [3,9,20,null,null,15,7],
;
;  3
; / \
;9   20
;   /  \
;  15   7
;return its minimum depth = 2.

;2. Devise a plan
; We know that in a binary tree represented as an array, the index of the parent node for a given child
; is n//2.
; We can find the first leaf node by finding the index of the first nil.
; Then, we continue to //2 until we reach 1 (the root node)
; This is worst case O(N) performance.

;3. Carry out plan
(defn min-depth-w-math
  [bin-tree]
  (let [index-of-first-leaf-node (first
                                   (keep-indexed
                                     (fn [idx el]
                                       (when (nil? el) idx)) bin-tree))
        steps-to-parent (take-while #(> % 1) (iterate #(quot % 2) index-of-first-leaf-node)) ]
    (count steps-to-parent)))

;4. Look back
; This only worked if I added a 0 to the front of each array :(
; This also doesn't work for incomplete binary trees
; ex.
; 1
;	 \
;	  2
;	 /
;	3
; because that'd be represented like this
; [0, 1, nil, 2, nil, nil, 3, nil]
; and then the first nil is a child of the root node but the root node wouldn't be considered a leaf node.
; Continuing to represent the non-existent children of a non-existent node causes other problems.
; I was mistaken in thinking that binary trees were always represented as lists in this specific format.
; Back to the drawing board to use my newfound graph knowledge as this lesson originally intended.


;2. Devise a plan
;3. Carry out plan
;4. Look back