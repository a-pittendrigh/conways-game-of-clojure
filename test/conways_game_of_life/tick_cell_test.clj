(ns conways-game-of-life.tick-cell-test
  (:require [conways-game-of-life.tick-cell :as sut]
            [clojure.test :refer :all]
            [conways-game-of-life.statuses :as s]))

(def d {:state s/dead})
(def a {:state s/alive})

(deftest get-neighbourss
  (let [test-cell {:state d :x 1 :y 1}
        t test-cell
        world [[d d d]
               [d t d]
               [d d d]]]
    (is (= 0 (count (sut/living-neighbours t world))))
    (is (= 1 (count (sut/living-neighbours t (assoc-in world [0 1] a)))))
    (is (= 2 (count (sut/living-neighbours t (-> world
                                              (assoc-in [0 1] a)
                                              (assoc-in [0 0] a))))))))

(deftest tick-cell
  (is (= s/alive (:state (sut/tick-cell d [1 2 3])))))
