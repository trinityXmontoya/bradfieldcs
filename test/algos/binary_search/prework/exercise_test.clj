(ns algos.binary_search.prework.exercise_test
  (:require [clojure.test :refer :all]
            [algos.binary_search.prework.exercise :refer :all]))

(deftest binary-search-test
  (= false (binary-search [0, 1, 2, 8, 13, 17, 19, 32, 42] 3)
     true  (binary-search [0, 1, 2, 8, 13, 17, 19, 32, 42] 13)))