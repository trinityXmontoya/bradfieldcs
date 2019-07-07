(ns algos.methodical-problem-solving.prework.pangram-test
  (:require [clojure.test :refer :all]
            [algos.methodical_problem_solving.prework.pangram :refer :all]))

(deftest pangram-test
  (testing "is the given string a pangram?"
    (are [res str] (= (pangram? str) res)
                   true "the quick brown fox jumps over the lazy dog"
                   true "My girl wove six dozen plaid jackets before she quit!"
                   true "New job: fix Mr Gluck's hazy TV, PD"
                   false "Sadly, I am not a pangram :(")))
