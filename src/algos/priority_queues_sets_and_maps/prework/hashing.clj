(ns algos.priority_queues_sets_and_maps.prework.hashing
  (:require [clojure.string :as s]))

(defn folding-method
  [num num-of-slots]
  (let [digit-pairs (map #(read-string (s/join %)) (partition 2 2 nil (str num)))
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

