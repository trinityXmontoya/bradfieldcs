(ns algos.asymptotic_analysis.prework.analysis_test
  (:require [clojure.test :refer :all]
            [algos.asymptotic_analysis.prework.analysis :refer :all]))


(deftest angram-test
  (testing "are the given strings anagrams?"
    (are [res s1 s2] (= (anagram? s1 s2) res)
                true "earth" "heart"
                true "the eyes" "they see"
                true "the eyes" "they see"
                true "School master" "The classroom"
                false "not" "an anagram"
                false "heat" "heart")))