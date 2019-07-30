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
(defn -split-coll
  [coll]
  (split-at (quot (count coll) 2) coll))

(defn merge-and-count
  [coll]
  (if (< (count coll) 2)
    [coll 0]
      (let [[left right] (-split-coll coll)]
        (loop [final-coll []
               left left
               right right
               final-inv-count 0]
          (cond
            (empty? left)									[(concat final-coll right) final-inv-count]
            (empty? right) 								[(concat final-coll left)  final-inv-count]
            (< (first left) (first right)) (recur (conj final-coll (first left))
                                                  (rest left)
                                                  right
                                                  final-inv-count)
            :else													 (recur (conj final-coll (first right))
                                                   left
                                                   (rest right)
                                                   (+ final-inv-count (count left))))))))


(defn num-of-inversions-merge-sort
  [coll]
  (let [[[sorted-left left-invs] [sorted-right right-invs]] (map merge-and-count (-split-coll coll))
        mid-invs 0]

    (+ left-invs
       right-invs
       mid-invs)


    ))

;4. Looking back
