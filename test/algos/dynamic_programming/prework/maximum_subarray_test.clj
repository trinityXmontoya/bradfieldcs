(ns algos.dynamic_programming.prework.maximum_subarray_test
  (:require [clojure.test :refer :all]
            [algos.dynamic_programming.prework.maximum_subarray :refer :all]))

(deftest maximum-subarray-test
    (are [max arr] (= (maximum-subarray arr) max)
                    6 [-2, 1,-3, 4,-1, 2, 1,-5, 4]
                   21 [ 2, 3, 4, 5, 7]
                    7 [-2,-5, 6,-2,-3, 1, 5, -6]
                   15 [ 1, 5,-1, 0,10]
                    0 [ 0,-1,-5, 0,-4]))