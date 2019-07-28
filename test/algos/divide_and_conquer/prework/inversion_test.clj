(ns algos.divide_and_conquer.prework.inversion_test
  (:require [clojure.test :refer :all]
            [algos.divide_and_conquer.prework.inversion :refer :all]))


(deftest num-of-inversions-test
  (testing "are the given strings anagrams?"
    (are [res coll] (= (num-of-inversions coll) res)
                    3 [2,  4, 1, 3, 5]
                    5 [1, 20, 6, 4, 5]
                    0 [1]
                    0 [])))