(ns algos.binary_search.postwork.matrix_test
  (:require [clojure.test :refer :all]
            [algos.binary_search.postwork.matrix :refer :all]))

(deftest  matrix-test
          (are [res matrix el] (= (search-matrix matrix el) res)
               true [[1,   3,  5,  7]
                     [10, 11, 16, 20]
                     [23, 30, 34, 50]] 3

               false [[1,   3,  5,  7]
                      [10, 11, 16, 20]
                      [23, 30, 34, 50]] 13))