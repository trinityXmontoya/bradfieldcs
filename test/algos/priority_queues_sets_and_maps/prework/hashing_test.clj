(ns algos.priority_queues_sets_and_maps.prework.hashing_test
  (:require [clojure.test :refer :all]
            [algos.priority_queues_sets_and_maps.prework.hashing :refer :all]))


(deftest folding-method-test
  (is (= (folding-method 4365554601 11) 1)))

(deftest hash-string-test
  (is (= (hash-string "cat" 11) 3)))