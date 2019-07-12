(ns algos.stacks_queues_dequeues.prework.stacks)

;1. Understand the problem
;Given a string of parentheses determine whether they are balanced, meaning
;"that each opening symbol has a corresponding closing symbol and the pairs of parentheses are properly nested"
;Use a stack.
;
;2. Devise a plan
;Some observations. If a string has an odd-length the parentheses cannot match -> O(1) to check
;If the first character is not a '(' or the last character is not a ')' they also cannot match -> O(1) for first + last
;Once those cases are out of the way, use a stack to `push` '('s onto the stack, and then `pop` them if the
;next element is a ')'. The stack should be empty at the end.
;
; 3. Carry out the plan
(defn -opening-parens?
  [s]
  (= s \())

(defn -closing-parens?
  [s]
  (= s \)))

(defn is-balanced?
  [s]
  (cond
    (odd? (count s)) false                                  ; O(1)
    (not                                                    ; O(1)
      (and
        (-opening-parens? (first s))
        (-closing-parens? (last s)))) false
    :else (zero?
            (count                                          ; O(1)
              (reduce                                         ; O(N)
                (fn [stack char]
                  (if (-opening-parens? char)                 ; O(1)
                    (conj stack char)                         ; O(1)
                    (if (zero? (count stack))                 ; O(1)
                      (reduced `(nil))
                      (pop stack))))                          ; O(1)
                `()
                s)))))
;4. Look back
;I originally attempted to copy the implementation of [`frequencies`](https://github.com/clojure/clojure/blob/841fa60b41bc74367fb16ec65d025ea5bde7a617/src/clj/clojure/core.clj#L7123)
;which uses [transient data structures](https://clojure.org/reference/transients) as a way to accomplish Clojure-y mutation within a specific scope.
;I found that while I could "push" items to the front of a vector, I could not "pop" them. I was about to just use loop/recur
;when I realized there's no reason I actually need a transient data structure 🙃. [`reduced`](https://clojuredocs.org/clojure.core/reduced)
;allows early exit from a `reduce`. I don't love that in order to exit early when there are no more opening parentheses
;in the stack that I am creating a list with a nil element.
; time complexity: O(N)