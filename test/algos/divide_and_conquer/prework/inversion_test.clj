(ns algos.divide_and_conquer.prework.inversion_test
  (:require [clojure.test :refer :all]
            [algos.divide_and_conquer.prework.inversion :refer :all]))


(deftest num-of-inversions-multi-test
    (are [res coll] (= (num-of-inversions-multi coll) res)
                    5 [1, 20, 6, 4, 5]
                    3 [2,  4, 1, 3, 5]
                    1 [2 1]
                    0 [1]
                    0 []))

(deftest num-of-inversions-indices-test
  (are [res coll] (= (num-of-inversions-indices coll) res)
                  5 [1, 20, 6, 4, 5]
                  3 [2,  4, 1, 3, 5]
                  1 [2 1]
                  0 [1]
                  0 []))