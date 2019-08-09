(ns algos.dynamic_programming.prework.maximum_subarray)

;1. Understand the problem
;src: https://leetcode.com/problems/maximum-subarray/description/
;Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
;
;Example:
;
;Input: [-2,1,-3,4,-1,2,1,-5,4],
;Output: 6
;Explanation: [4,-1,2,1] has the largest sum = 6.

;2. Devise a plan
; This reminds me of the exercise in class where we had to find the largest window of trues in a given array of booleans.
; We used binary search to determine window size but that had O(N * log N) performance and the instructions suggest there
; is an O(N) solution. The window size exercise in class also had an O(N) solution that Lee & I both got which was to turn
; T + Fs into 0s and 1s and then check which window size had the highest value by moving start + end pointers through
; the array. In this case each element is already its value and doesn't need to be encoded so the idea of just moving the
; the pointer while keeping track of the highest value seen so far should work. Unlike the T/F problem, I want to start off
; with passing the whole array rather than the value so I can debug more easily if this is a poor approach.
;
;3. Carry out plan
(defn maximum-subarray
  [nums]
  (loop [i 1
         current-max (first nums)
         current-window [current-max]]
    (let [el-to-compare (nth nums i nil)]
      (if (nil? el-to-compare)
        current-max
        (if (> el-to-compare (+ el-to-compare (reduce + current-window)))
          (let [new-window [el-to-compare]
                new-max (max current-max el-to-compare)]
            (recur (inc i) new-max new-window))
          (let [new-window (conj current-window el-to-compare)
                new-max (max current-max (reduce + new-window))]
            (recur (inc i) new-max new-window)))))))

;4. Look back
; Given that this works I'd want to reimplement using only pointers and values and not have to create new arrays to pass around.
