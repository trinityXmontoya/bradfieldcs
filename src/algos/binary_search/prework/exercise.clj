(ns algos.binary_search.prework.exercise
  (:require [clojure.string :as s]))

(defn binary-search
  [coll el]
  (loop [coll coll]
    (if (empty? coll)
      false
      (let [midpoint (quot (count coll) 2)
            midpoint-el (get coll midpoint)]
        (cond
          (= el midpoint-el) true
          (< el midpoint-el) (recur (subvec coll 0 midpoint))
          (> el midpoint-el) (recur (subvec coll (inc midpoint))))))))
