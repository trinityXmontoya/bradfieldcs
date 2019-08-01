(ns algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree_test
  (:require [clojure.test :refer :all]
            [algos.graph_search.bfs_and_dfs.prework.minimum_depth_binary_tree :refer :all]))


(deftest min-depth-test
  (is (= (min-depth [3, 9, 20, nil, nil, 15, 7]) 2)))