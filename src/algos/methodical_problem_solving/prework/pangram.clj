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
;[This resource](https://swtch.com/~rsc/regexp/regexp1.html) was most helpful and I was moved by
;"Some might argue that this test is unfair to the backtracking implementations, since it focuses on an uncommon corner case.
;This argument misses the point: given a choice between an implementation with a predictable, consistent, fast running time
;on all inputs or one that usually runs quickly but can take years of CPU time (or more) on some inputs, the decision should be easy."
;
;3. Carry out the plan
(def chars-of-the-alphabet-0
  #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})

(defn pangram-0?
  [s]
  (let [lower-cased-s (str/lower-case s)]
    (every? (set lower-cased-s) chars-of-the-alphabet-0)))

;4. Look back
;Passes tests, but can it be solved w/o creating a set? Even if set lookup is efficient, this requires iterating
;through each character and adding it to the set which is O(N).


;----------------
;APPROACH 1
;----------------
;2. Devise a plan
;Write a function that determines if a string is a pangram w/o changing the data structure.
;Sequence functions are idiomatic Clojure but If I use `map`, I'll have to iterate through at least all 26 letters of the alphabet
;even though I should be exiting once a match isn't found. Clojure is written in Java which doesn't currently support
;tail-call optimization but it does have `loop`/`recur` ["which does constant-space recursive looping"](https://clojure.org/about/functional_programming#_recursive_looping)

;3. Carry out the plan
(def chars-of-the-alphabet-1
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn pangram-1?
  [s]
  (let [lower-cased-s (str/lower-case s)]
    (loop [current-char (first chars-of-the-alphabet-1)
           remaining-chars (rest chars-of-the-alphabet-1)]
      (cond
        (nil? current-char) true
        (str/includes? lower-cased-s current-char) (recur (first remaining-chars) (rest remaining-chars))
        :else false))))

;4. Look back
;Passes tests, but I don't love that I'm:
;- checking if the current character is nil each time
;- checking the entire input string each time (`str/includes?` uses Java's `String.contains` under the hood which uses
;`String.indexOf` which has O(N) complexity but I'm running it between 1 & 26 times.
