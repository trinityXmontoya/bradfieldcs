(ns algos.divide_and_conquer.prework.inversion)

;Count the # of inversions in an array

(defn num-of-inversions
  ([coll]
   (if (< (count coll) 2)
     0
     (apply
       +
       (keep-indexed
         (fn [outer-idx outer-el]
           (let [sub-coll (subvec coll (inc outer-idx))]
             (num-of-inversions sub-coll outer-el)))
         coll))))
  ([coll el]
    (apply
      +
      (keep
        (fn [inner-el]
          (when (> el inner-el) 1))
        coll))))




