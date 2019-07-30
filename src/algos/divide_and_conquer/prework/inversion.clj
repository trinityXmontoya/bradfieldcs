(ns algos.divide_and_conquer.prework.inversion)

;1. Understand the problem
;Count the # of inversions in an array
;An inversion is how many swaps need to be made in order for the array to be sorted

;2. Devise a plan
;trying out multimethods

;3. Carry out plan
(defn num-of-inversions-multi
  ([coll]
     (apply
       +
       (keep-indexed
         (fn [outer-idx outer-el]
           (let [sub-coll (subvec coll (inc outer-idx))]
             (num-of-inversions-multi sub-coll outer-el)))
         coll)))
  ([coll el]
   (if (empty? coll)
     0
     (apply
       +
       (keep
         (fn [inner-el]
           (when (> el inner-el) 1))
         coll)))))

;4. Looking back
;Dont need to create new collections, use indices

;2. Devise a plan
; Use indices

;3. Carry out plan
(defn num-of-inversions-indices
  ([coll]
   (apply
     +
     (keep-indexed
       #(num-of-inversions-indices coll %1 %2)
       coll)))
  ([coll idx el]
   (if (empty? coll)
     0
     (apply
       +
       (keep
         #(when (> el (get coll %)) 1)
         (range idx (count coll)))))))

;4. Looking back
;I don't really like this.

;2. Devise a plan
;Use merge sort

;3. Carry out plan
(defn num-of-inversions-merge-sort
  [coll])

;4. Looking back
