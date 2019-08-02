(ns algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree_test
  (:require [clojure.test :refer :all]
            [algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree :refer :all]))


(deftest min-depth-w-math-test
    (are [res bin-tree] (= (min-depth-w-math bin-tree) res)
                        2 [3, 9, 20, nil, nil, 15, 7]
                        2 [1, 2, 3, 4, 5, nil, nil]
                        3 [1, nil, 2, nil, nil, 3, nil]))

(deftest min-depth-w-tree-test
  (are [res bin-tree] (= (min-depth-w-tree bin-tree) res)
                      2 {:val 3
                         :left {:val 9
                                :left nil
                                :right nil}
                         :right {:val 20
                                 :left {:val 15}
                                 :right {:val 7}}}

                      2 {:val 1
                         :left {:val 2
                                :left {:val 4}
                                :right {:val 5}}
                         :right {:val 3
                                 :left nil
                                 :right nil}}))