(ns algos.divide_and_conquer.prework.inversion)

;Count the # of inversions in an array

(defn num-of-inversions
  [coll]
  (if (< 2 (count coll))
    0
    ()))