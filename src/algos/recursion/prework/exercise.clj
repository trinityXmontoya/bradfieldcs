(ns algos.recursion.prework.exercise)

(defn sum-of-nums
  [nums]
  (reduce + nums))

(defn sum-of-nums-recursive
  [nums]
  (loop [remaining-nums (rest nums)
         final-sum (first nums)]
    (if (empty? remaining-nums)
      final-sum
      (recur (rest remaining-nums) (+ final-sum (first remaining-nums))))))