(ns algos.recursion.prework.exercise_test
  (:require [clojure.test :refer :all]
            [algos.recursion.prework.exercise :refer :all]))

(deftest sum-of-nums-test
  (is (= (sum-of-nums [1 3 5 7 9]) 25)))

(deftest sum-of-nums-recursive-1-test
  (is (= (sum-of-nums-recursive-1 [1 3 5 7 9]) 25)))

(deftest sum-of-nums-recursive-2-test
  (is (= (sum-of-nums-recursive-2 [1 3 5 7 9]) 25)))