(ns algos.binary_search.prework.exercise)

(defn binary-search
  [coll item]
  (loop [coll coll]
    (cond
      (empty? coll)         false
      (< item (first coll)) false
      (> item (last coll))  false
      :else
        (let [midpoint (quot (count coll) 2)
              midpoint-el (get coll midpoint)]
          (cond
            (= item midpoint-el) true
            (< item midpoint-el) (recur (subvec coll 0 midpoint))
            (> item midpoint-el) (recur (subvec coll (inc midpoint))))))))

;4. Looking back
; unlike Python's slice, subvec is O(1)
; There is a memory cost to this but because Clojure uses structural sharing and implements vectors as trees, when we
; create a 'new' vector we copy *references* to the original vector rather than the values themselves which saves having
; to copy the entire vector.
; (src: https://www.infoq.com/articles/in-depth-look-clojure-collections/, CMD+F 'Clojure's persistent collections' + https://hackernoon.com/how-immutable-data-structures-e-g-immutable-js-are-optimized-using-structural-sharing-e4424a866d56)
