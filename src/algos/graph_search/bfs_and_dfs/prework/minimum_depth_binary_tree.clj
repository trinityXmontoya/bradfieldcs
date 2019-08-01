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
; We know that in a binary tree represented as an array, the index of the parent node (P) for a given child index (N)
; is P = (N + (root_index - 1)) // 2.
; We can find the first leaf node by finding the parent index of the first nil.
; Then, we continue to find the parent index until we reach 0 (the root node)
; This is worst case O(N) performance.

;3. Carry out plan
(declare leaf-node?)

(defn parent-idx
  [idx]
  (let [root-idx 0]
    (quot (+ idx (dec root-idx)) 2)))

(defn min-depth-w-math
  [bin-tree]
  (let [leaf-node-idx (first
                        (keep-indexed
                          (fn [idx el]
                            (when (nil? el) idx)) bin-tree))
        steps-to-root (take-while #(> % 0) (iterate parent-idx leaf-node-idx))]
    (count steps-to-root)))

;4. Look back
; This doesn't work for incomplete binary trees
; ex.
; 1
;	 \
;	  2
;	 /
;	3
; because that'd be represented as
; [1, nil, 2, nil, nil, 3, nil, nil, nil, nil, nil]
; the first nil in this case is the child of root node which isn't a leaf node
; the second nil is the child of a nonexistent parent
; I could identify the first leaf node by confirming the parent is *not* nil and doesn't have other children
; but then for every node i'm checking all its connected ones
(defn leaf-node?
  [idx coll]
  (let [node (get coll idx)
        parent (get coll (parent-idx idx))
        left-child (get coll (+ 1 (* 2 idx)))
        right-child (get coll (+ 2 (* 2 idx)))]
    (and
      (nil? node)
      (not (nil? parent))
      (nil? left-child)
      (nil? right-child))))
; Back to the drawing board to use my newfound graph knowledge as this lesson originally intended!


;2. Devise a plan
; Build and use a graph to find the first leaf node
; since we want the first leaf node
;
;3. Carry out plan
(defn node
  [val]
  {:val val
   :left nil
   :right nil})

(defn build-tree
  [coll]
  {
   :val 3
   :left {
          :val 9
          :left nil
          :right nil
          }
   :right {
           :val 20
           :left {
                  :val 15
                  }
           :right {
                   :val 7
                   }
           }
   })

(defn min-depth
  [coll]
  (let [bin-tree (build-tree coll)]
    (loop [tree bin-tree]
      (let [root (tree :val)
            left (tree :left)
            right (tree :right)]



        )


      )
    ))

;4. Look back