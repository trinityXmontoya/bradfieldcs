(ns algos.binary_search.prework.exercise)

;An implementation of recursive binary search:
(defn binary-search-recursive
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
;
; After further thought there's ~no~ reason I have to manipulate or pass around the vector at all, I can just use the indices.
; I also remove the check for whether it's within the given range bc I don't know if that goes against the implementation of binary search(?)
; Doesn't seem like it should and it prevents you from doing unnecessary math but jic...
(defn binary-search
  [coll item]
  (if (empty? coll)
    false
    (loop [lower-bound 0
           upper-bound (dec (count coll))]
      (if
        (< (- upper-bound lower-bound) 1) (= (coll lower-bound) item)
        (let [midpoint (quot (+ lower-bound upper-bound) 2)
              midpoint-el (coll midpoint)]
          (cond
            (= item midpoint-el) true
            (< item midpoint-el) (recur lower-bound (dec midpoint))
            (> item midpoint-el) (recur (inc midpoint) upper-bound)))))))