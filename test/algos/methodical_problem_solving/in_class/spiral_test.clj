(ns algos.methodical-problem-solving.in_class.spiral_test
  (:require [clojure.test :refer :all]
            [algos.methodical_problem_solving.in_class.spiral :refer :all]))


(deftest spiral-test
  (testing "is the given string a pangram according to pangram-2 fn?"
    (are [res n] (= (spiral n) res)
                 1 [[1]]

                 2 [[1,2]
                    [4,3]]

                 3 [[1,2,3]
                    [8,9,4]
                    [7,6,5]]

                 4 [[ 1, 2, 3, 4]
                    [12,13,14, 5]
                    [11,16,15, 6]
                    [10, 9, 8, 7]])))