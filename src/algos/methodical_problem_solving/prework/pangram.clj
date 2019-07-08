(ns algos.methodical_problem_solving.prework.pangram
  (:require [clojure.string :as str]))

;1. Understand the problem:
;Write a function that takes a string and returns a boolean indicating whether the string
;contains all 26 characters of the English alphabet at least once
;
;----------------
;APPROACH 0
;----------------
;2. Devise a plan
;Write tests as a way to suss out possible edge-cases (capitalization, punctuation)
;Think about possible data structures / needed variables / approaches (list of all 26 chars, sets, regex)
;The idea of a set is attractive because they guarantee we care about membership not frequency of each individual
;character and lookup is O(1).
;The idea of a regex is attractive because it doesn't require me writing out or copy/pasting all 26 letters of the alphabet
;but I've heard they can be computationally expensive to use and if the intention is general purpose problem-solving perhaps
;it's not the best choice. But this is an assumption! So I researched regexes to figure out how they're actually implemented.
; [This resource](https://swtch.com/~rsc/regexp/regexp1.html) was most helpful and I was moved by
; "Some might argue that this test is unfair to the backtracking implementations, since it focuses on an uncommon corner case.
; This argument misses the point: given a choice between an implementation with a predictable, consistent, fast running time
; on all inputs or one that usually runs quickly but can take years of CPU time (or more) on some inputs, the decision should be easy."
;
;3. Carry out the plan
(def chars-of-the-alphabet
  #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})

(defn pangram-0?
  [s]
  (every? (set (str/lower-case s)) chars-of-the-alphabet))

;4. Look back
;Passes tests, but can it be solved w/o creating a set? Even if set lookup is efficient, this requires iterating
;through each character and adding it to the set which is O(N).