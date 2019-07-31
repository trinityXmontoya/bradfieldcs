(ns algos.divide_and_conquer.in_class.thanos)

;1. Understand the problem
;https://codeforces.com/problemset/problem/1111/C

;2. Devise a plan
;Break down into pairs, do the math for each pair, take the lower number, and return

(defn thanos
  [base-pwr num-of-avngs power-a power-b]
  (let [base-len (repeat base-pwr (* 2 2))]

    ; 1 divide to left and right
    ; continue to break each down until you only have 2
    ; when you have 2, compare the two vals
    ; add the final

    ))