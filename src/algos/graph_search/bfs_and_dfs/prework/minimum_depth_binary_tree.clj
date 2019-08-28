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
  [coll])

(defn min-depth-w-tree
  [bin-tree]
    (loop [tree bin-tree
           depth 0]
      (cond
        ; current node does not exist
        (nil? (tree :val)) 0

        ; reached end of left + right subtree -> add 1 (parent)
        (and (nil? (tree :left))
             (nil? (tree :right))) 1

        ; reached end of left subtree -> traverse right + add 1 for this being left leaf node
        (nil? (tree :left)) (recur (tree :right) (inc depth))

        ; reached end of right subtree -> traverse left + add 1 for this being right leaf node
        (nil? (tree :right)) (recur (tree :left) (inc depth))

        ; traverse & compare left subtree + right subtree, add 1 for current parent
        :else (inc
                (min (min-depth-w-tree (tree :left))
                     (min-depth-w-tree (tree :right)))))))

;4. Look back
; I pass the input array as a tree (I started off with it as an array and the first
; step in `min-depth-w-tree` was converting it to a tree but as I was planning out the recursive calls I
; realized I'd have to convert the left & right subtrees back to arrays just for them to be able to use the
; min-depth-w-tree function.
; Though this is O(N) because I'm only going through each node of the tree once, there must be a way to
; properly exit when I find the *first* leaf node as in my first attempt. You can imagine the first child
; of the root node is a leaf node but this will still traverse the entire tree.
; I shouldn't've spent so much time on my first approach, esp bc it wasn't even utilizing new things I learned. Going to reread the trees + graph work and see if I come up with something better.


;2. Devise a plan
; postorder traversal?
;
;3. Carry out plan
;4.