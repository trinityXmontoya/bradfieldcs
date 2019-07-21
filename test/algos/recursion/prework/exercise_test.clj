(ns algos.recursion.prework.exercise_test
  (:require [clojure.test :refer :all]
            [algos.recursion.prework.exercise :refer :all]))

(deftest sum-of-nums-test
  (is (= (sum-of-nums [1 3 5 7 9]) 25)))

(deftest sum-of-nums-recursive-test
  (is (= (sum-of-nums-recursive [1 3 5 7 9]) 25)))