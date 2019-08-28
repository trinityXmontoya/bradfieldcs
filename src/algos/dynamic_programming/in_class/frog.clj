(ns algos.dynamic_programming.in_class.frog)

;(def arr [4 2 4 3 2 3 1]) = 7

;A frog can take 1 or 2 hops. Each hop 'costs' the height difference between the current node and the node you choose to jump to.
;What is the minimum height difference for the frog to traverse the nodes?
(defn frog
  [towers]
  (let [last-tower-idx (count towers)]
    (loop [i 0
           current-steps {0 0}]
      (if (> i last-tower-idx)
        (current-steps last-tower-idx)


      (let [one-hop-idx (inc i)
            one-hop-cost (nth towers one-hop-idx)
            two-hop-idx (+ i 2)
            two-hop-cost (nth towers two-hop-idx)]

        (recur (inc i) (assoc current-steps )))





        ))

      )


    )
