(ns algos.stacks_queues_dequeues.prework.stacks_test
  (:require [clojure.test :refer :all]
            [algos.stacks_queues_dequeues.prework.stacks :refer :all]))

(deftest balanced-parens-test
  (testing "is the given string of parentheses balanced?"
    (are [res parentheses] (= (balanced-parens? parentheses) res)
                     true "(()()()())"
                     true "(((())))"
                     true "(()((())()))"
                     false "((((((())"
                     false "()))"
                     false "(()()(()")))

(deftest balanced-symbols-test
  (testing "is the given string of symbols balanced?"
    (are [res symbols] (= (balanced-symbols? symbols) res)
                           true "{{([][])}()}"
                           true "((()))"
                           false "{[])"
                           false "(()"
                           false "())")))

(deftest convert-to-binary-test
  (testing ""
    (are [binary int] (= (convert-to-binary int) binary)
                      "101010" 42
                      "11101001" 233)))