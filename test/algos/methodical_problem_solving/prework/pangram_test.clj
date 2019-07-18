(ns algos.methodical-problem-solving.prework.pangram-test
  (:require [clojure.test :refer :all]
            [algos.methodical_problem_solving.prework.pangram :refer :all]))

(def pangrams
  ["the quick brown fox jumps over the lazy dog"
   "My girl wove six dozen plaid jackets before she quit!"
   "J.Q. Schwartz flung V.D. Pike my box"])

(def not-pangrams
  ["Sadly, I am not a pangram :("])

(deftest pangram-1-test
  (testing "is the given string a pangram according to pangram-1 fn?"
    (doseq [pangram pangrams]
      (is (true? (pangram-1? pangram)) "for known valid pangrams"))
    (doseq [pangram not-pangrams]
      (is (false? (pangram-1? pangram)) "for known invalid pangrams"))))

(deftest pangram-2-test
  (testing "is the given string a pangram according to pangram-2 fn?"
    (doseq [pangram pangrams]
      (is (true? (pangram-2? pangram)) "for known valid pangrams"))
    (doseq [pangram not-pangrams]
      (is (false? (pangram-2? pangram)) "for known invalid pangrams"))))

(deftest pangram-3-test
  (testing "is the given string a pangram according to pangram-3 fn?"
    (doseq [pangram pangrams]
      (is (true? (pangram-3? pangram)) "for known valid pangrams"))
    (doseq [pangram not-pangrams]
      (is (false? (pangram-3? pangram)) "for known invalid pangrams"))))
