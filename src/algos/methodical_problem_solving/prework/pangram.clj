(ns algos.methodical_problem_solving.prework.pangram
  (:require [clojure.string :as str]))

;----------------
;APPROACH 1
;----------------
;1. Understand the problem:
;Write a function that takes a string and returns a boolean indicating whether the string
;contains all 26 characters of the English alphabet at least once
;
;2. Devise a plan
;Write tests as a way to suss out possible edge-cases (capitalization, punctuation)
;Think about possible data structures / needed variables / approaches (list of all 26 chars, sets, regex)
;The idea of a set is attractive because we care about membership not frequency of each individual
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
(def alphabet-as-set
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn pangram-1?
  [string]
  (let [string-as-set (set (str/lower-case string))]
    (every? string-as-set alphabet-as-set)))

;4. Look back
;Passes tests, but can it be solved w/o creating a set? Even if set lookup is efficient, this requires iterating
;through each character and adding it to the set which is O(N).


;----------------
;APPROACH 2
;----------------
;1. Understand the problem:
;Write a function that determines if a string is a pangram w/o changing the data structure.
;
;2. Devise a plan
;Sequence functions are idiomatic Clojure but If I use `map`, I'll have to iterate through at least all 26 letters of the alphabet
;even though I should be exiting once a match isn't found. Clojure is written in Java which doesn't currently support
;tail-call optimization but it does have `loop`/`recur` ["which does constant-space recursive looping"](https://clojure.org/about/functional_programming#_recursive_looping)

;3. Carry out the plan
(def alphabet-as-vec
  ["a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"])

(defn pangram-2?
  [string]
  (let [lower-cased-string (str/lower-case string)]
    (loop [current-char (first alphabet-as-vec)
           remaining-chars (rest alphabet-as-vec)]
      (cond
        (nil? current-char) true
        (str/includes? lower-cased-string current-char) (recur (first remaining-chars) (rest remaining-chars))
        :else false))))

; similar
; (defn pangram-2?
;  [string]
;  (let [lower-cased-string (str/lower-case string)]
;    (= (count alphabet-as-vec)
;       (count
;         (for [char alphabet-as-vec
;               :while (str/includes? lower-cased-string char)]
;           char)))))

;4. Look back
;Passes tests, but I don't love that I'm:
;- checking if the current character is nil each time
;- checking the entire input string each time (`str/includes?` uses Java's `String.contains` under the hood which uses
;`String.indexOf` which has O(N) complexity but I'm running it up to 26 times).


;----------------
;APPROACH 3
;----------------
;1. Understand the problem:
;Write a function that determines if a string is a pangram w/o checking the entire sentence each time.
;
;2. Devise a plan
;If I don't want to check the entire sentence each time I could keep a separate record of which characters I've found
;so far. If I build *up* a set, I'd have to check before each insert whether the character is part of the alphabet.
;If I build *down* a set, I would already have the 26 characters. Either way Clojure's data structures are immutable and
;I'm not sure what the performance implications of creating a new set each time I add / remove an element would be.
; Some pseduocode:
;for char in string
;  if char in alphabet
;    if already in final-set
;      next
;    elsif count final-set == 25
;      true
;      exit
;    else
;      next
;    end
;  else
;    next
;  end
;end
; false

;3. Carry out the plan
(defn pangram-3?
  [string]
  (let [lower-cased-string (str/lower-case string)]))

;4. Look back
;