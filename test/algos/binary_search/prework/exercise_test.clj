(ns algos.binary_search.prework.exercise_test
  (:require [clojure.test :refer :all]
            [algos.binary_search.prework.exercise :refer :all]))

(deftest  binary-search-recursive-test
    (are [res coll item] (= (binary-search-recursive coll item) res)
                       false [0, 1, 2, 8, 13, 17, 19, 32, 42] 3   ; example from reading
                       false [] 3                                 ; 0 el array
                       false [4] 3                                ; 1 el array
                       false [0, 1, 2, 2, 2, 8, 13, 17, 19, 32] 3 ; repeated els

                       true  [0, 1, 2, 8, 13, 17, 19, 32, 42] 13  ; example from reading
                       true  [4] 4                                ; 1 el array
                       true  [0, 1, 2, 8, 13, 17, 19, 32, 42] 42  ; el is last val
                       true  [0, 1, 2, 2, 2, 8, 13, 17, 19, 32] 2 ; repeated els
     ))

(deftest  binary-search-test
  (are [res coll item] (= (binary-search coll item) res)
                       false [0, 1, 2, 8, 13, 17, 19, 32, 42] 3   ; example from reading
                       false [] 3                                 ; 0 el array
                       false [4] 3                                ; 1 el array
                       false [0, 1, 2, 2, 2, 8, 13, 17, 19, 32] 3 ; repeated els

                       true  [0, 1, 2, 8, 13, 17, 19, 32, 42] 13  ; example from reading
                       true  [4] 4                                ; 1 el array
                       true  [0, 1, 2, 8, 13, 17, 19, 32, 42] 42  ; el is last val
                       true  [0, 1, 2, 2, 2, 8, 13, 17, 19, 32] 2 ; repeated els
                       ))