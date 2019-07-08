(ns algos.methodical-problem-solving.prework.pangram-test
  (:require [clojure.test :refer :all]
            [algos.methodical_problem_solving.prework.pangram :refer :all]))

(deftest pangram-0-test
  (testing "is the given string a pangram?"
    (are [res str] (= (pangram-0? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "J.Q. Schwartz flung V.D. Pike my box"
                   false "Sadly, I am not a pangram :(")))

(deftest pangram-1-test
  (testing "is the given string a pangram?"
    (are [res str] (= (pangram-1? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "J.Q. Schwartz flung V.D. Pike my box"
                   false "Sadly, I am not a pangram :(")))
