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
(defn merge-sort
  [coll]
  (if (< (count coll) 2)
    coll
    (let [[left right] (split-at (quot (count coll) 2) coll)]
      (loop [final-coll []
             left (merge-sort left)
             right (merge-sort right)]
        (cond
          (empty? left)									 (concat final-coll right)
          (empty? right) 								 (concat final-coll left)
          (< (first left) (first right)) (recur (conj final-coll (first left)) (rest left) right)
          :else													 (recur (conj final-coll (first right)) left (rest right)))))))

(defn num-of-inversions-merge-sort
  [coll]
  (let [[left right] (split-at (quot (count coll) 2) coll)
        sorted-left (merge-sort left)
        sorted-right (merge-sort right)
        mid-idx (count sorted-left)]
    (loop [left-idx 0
           right-idx 0
           inv-cnt 0]
      (let [left-el (nth sorted-left left-idx nil)
            right-el (nth sorted-right right-idx nil)]

        (when (= coll   [1 20 6 4 5])
          (println "LFET:" sorted-left)
          (println "RIGHT:" sorted-right)

          (println "left el:" left-el)
          (println "right el:" right-el)
          (println "current inv:" inv-cnt)
          (println "new inv:"
                   (if (and (not (nil? left-el)) (not (nil? right-el)) (> left-el right-el))
                     (+ inv-cnt (- mid-idx left-idx))
                     inv-cnt))
          )

      (cond
        (nil? left-el) inv-cnt
        (nil? right-el) inv-cnt
        (and (> left-el right-el)) (recur (inc left-idx) (inc right-idx) (+ inv-cnt (- mid-idx left-idx)))
        :else (recur (inc left-idx) right-idx inv-cnt ))))))

;4. Looking back
