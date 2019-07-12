(ns algos.stacks_queues_dequeues.prework.stacks_test
  (:require [clojure.test :refer :all]
            [algos.stacks_queues_dequeues.prework.stacks refer :all]))


(deftest is-balanced-test
  (testing "is the given string of parentheses balanced?"
    (are [res parentheses] (= (is-balanced? parentheses) res)
                     true "(()()()())"
                     true "(((())))"
                     true "(()((())()))"
                     false "((((((())"
                     false "()))"
                     false "(()()(()")))