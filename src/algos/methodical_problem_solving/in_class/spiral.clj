(ns algos.methodical_problem_solving.in_class.spiral
  (:require [clojure.string :as str]))

;1. Understand the problem:
;Given a number N where N > 0, return a 2D array of size NxN with the numbers 1 to N filled in
;counter-clockwise. example:
; input -> N = 3
; output -> [[1,2,3]
;            [8,9,4]
;            [7,6,5]]
;2. Devise a plan
;3. Carry out the plan
;4. Look back
(defn spiral
  [n]
  (let [nums (range 1 (inc n))]))