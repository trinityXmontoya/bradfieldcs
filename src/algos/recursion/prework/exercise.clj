(ns algos.recursion.prework.exercise)

;----------
;INTRO
;----------
(defn sum-of-nums
  [nums]
  (reduce + nums))

;base case: empty list
(defn sum-of-nums-recursive-1
  [nums]
  (loop [remaining-nums (rest nums)
         final-sum (first nums)]
    (if (empty? remaining-nums)
      final-sum
      (recur (rest remaining-nums) (+ final-sum (first remaining-nums))))))

;base case: list of 1 element, saves last call
(defn sum-of-nums-recursive-2
  [nums]
  (loop [remaining-nums (rest nums)
         final-sum (first nums)]
    (if (= 1 (count remaining-nums))
      (+ final-sum (first remaining-nums))
      (recur (rest remaining-nums)
             (+ final-sum (first remaining-nums))))))
