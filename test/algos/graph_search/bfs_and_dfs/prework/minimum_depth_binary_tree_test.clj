(ns algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree_test
  (:require [clojure.test :refer :all]
            [algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree :refer :all]))


(deftest min-depth-w-math-test
    (are [res bin-tree] (= (min-depth-w-math bin-tree) res)
                        2 [0, 3, 9, 20, nil, nil, 15, 7]
                        2 [0, 1, 2, 3, 4, 5, nil, nil]
                        3 [0, 1, nil, 2, nil, nil, 3, nil]))

