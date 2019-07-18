(ns algos.priority_queues_sets_and_maps.prework.hashing)

(defn -num-to-digits
  [num]
  (map
    #(rem % 10)
    (take-while
      (partial < 0)
      (iterate #(quot % 10) num))))

(defn folding-method
  [num num-of-slots]
  (let [digit-pairs (partition 2 2 nil (-num-to-digits num))
        sum-of-digits (reduce + digit-pairs)]
    (mod sum-of-digits num-of-slots)))

(defn hash-string
  "takes a string and a table size and returns the hash value in the range from 0 to tablesize - 1.
   uses the position of the character as a weight"
  [s table-size]
  (mod
    (reduce +
            (map-indexed
              (fn [idx char] (* (int char) (inc idx)))
              s))
    table-size))

