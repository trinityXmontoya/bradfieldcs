(ns algos.methodical-problem-solving.prework.pangram-test
  (:require [clojure.test :refer :all]
            [algos.methodical_problem_solving.prework.pangram :refer :all]))

(deftest pangram-1-test
  (testing "is the given string a pangram according to pangram-2 fn?"
    (are [res str] (= (pangram-1? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "J.Q. Schwartz flung V.D. Pike my box"
                   false "Sadly, I am not a pangram :(")))

(deftest pangram-2-test
  (testing "is the given string a pangram according to pangram-2 fn?"
    (are [res str] (= (pangram-2? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "J.Q. Schwartz flung V.D. Pike my box"
                   false "Sadly, I am not a pangram :(")))

(deftest pangram-3-test
  (testing "is the given string a pangram according to pangram-3 fn?"
    (are [res str] (= (pangram-3? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "J.Q. Schwartz flung V.D. Pike my box"
                   false "Sadly, I am not a pangram :(")))
