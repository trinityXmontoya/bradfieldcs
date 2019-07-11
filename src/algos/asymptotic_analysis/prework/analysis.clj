(ns algos.asymptotic_analysis.prework.analysis
  (:require [clojure.string :as str]))

;Say I wanted to calculate the sum of the first n numbers, and I’m wondering how long this will take. Firstly, can you
;think of a simple algorithm to do the calculation? It should be a function that has n as a parameter, and returns the
;sum of the first n numbers. You don’t need to do anything fancy, but please do take the time to write out an algorithm
;and think about how long it will take to run on small or large inputs.

; Clojure utilizes [lazy-evaluation](http://clojure-doc.org/articles/language/laziness.html#overview) through lazy sequences
; so even with larger ranges it doesn't evaluate them until it needs to sum them which offers advantages over other languages
; that will first need to store the entire sequence in memory. Then I read about potential downsides to lazy evaluation
; including -> thunk leaks! "A thunk leak is when a program builds up a lot of unevaluated thunks in memory which
; intrinsically take up a lot of space."
;(src: http://blog.ezyang.com/2011/05/space-leak-zoo/)
(defn sum-to-n
  [n]
  (reduce + (range 0 (inc n))))
; PROFILING:
;algos.core=> (map #(time (sum-to-n (* % 1000000))) (range 1 11))
;"Elapsed time: 44.732251 msecs"
;"Elapsed time: 61.726361 msecs"
;"Elapsed time: 90.809637 msecs"
;"Elapsed time: 119.782373 msecs"
;"Elapsed time: 148.348564 msecs"
;"Elapsed time: 174.791564 msecs"
;"Elapsed time: 202.473209 msecs"
;"Elapsed time: 227.27636 msecs"
;"Elapsed time: 254.373277 msecs"
;"Elapsed time: 282.996177 msecs"
; O(N) bc dependent on # of elements

(defn arithmetic-sum
  [n]
  (/ (* n (inc n)) 2))
; PROFILING:
;algos.core=> (map #(time (sum-to-n (* % 1000000))) (range 1 11))
;"Elapsed time: 44.732251 msecs"
;"Elapsed time: 61.726361 msecs"
;"Elapsed time: 90.809637 msecs"
;"Elapsed time: 119.782373 msecs"
;"Elapsed time: 148.348564 msecs"
;"Elapsed time: 174.791564 msecs"
;"Elapsed time: 202.473209 msecs"
;"Elapsed time: 227.27636 msecs"
;"Elapsed time: 254.373277 msecs"
;"Elapsed time: 282.996177 msecs"
; O(1) bc takes same amt of time regardless of input
; math == mind-blown


;1. Understand the problem
; Do the given strings have the same frequency of letters in a different order
;
;2. Devise a plan
; Clojure has a [`frequencies` fn](https://clojuredocs.org/clojure.core/frequencies) which will give the frequency of
; the characters in a string. This would tell me if they had the same characters but I'd need to do more work to find out
; if they appear in the same order.
; Other benefits to 'preprocessing' the chars in the string would be:
;- equality comparison which would tell us upfront whether they are the same letters in same order
;- length comparison which would tell us whether they have the same # of letters
; Rather than reading both strings entirely and then performing *more* work, I could loop through one string and:
; - see if each letter is the present in the other exiting if one isn't
; - keeping track of whether all the letters are in the same position
; based on the pangram solutions there may be a way of solving this using bits but I don't know it...yet ;)
;
; 3. Carry out the plan
(def alphabet-as-set
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn anagram?
  [s1 s2]
  (if (= s1 s2)
    false
    (let [s1chars  (filter #(contains? alphabet-as-set %) (.toLowerCase s1))
          s2chars  (filter #(contains? alphabet-as-set %) (.toLowerCase s2))]
      (if (not (= (count s1) (count s2)))
        false
        (= (frequencies s1chars) (frequencies s2chars))))))