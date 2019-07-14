(ns conways-game-of-life.tick-world-test
  (:require  [clojure.test :refer :all]
             [conways-game-of-life.tick-world :as sut]
             [conways-game-of-life.statuses :as s]
             [conways-game-of-life.cell :refer [make-cell]]))

(def d {:state s/dead})
(def a {:state s/alive})

(deftest tick-world
  (let [world [[(make-cell 0 0 s/dead) (make-cell 1 0 s/dead) (make-cell 2 0 s/dead)]
               [(make-cell 0 1 s/dead) (make-cell 1 1 s/dead) (make-cell 2 1 s/dead)]
               [(make-cell 0 2 s/dead) (make-cell 1 2 s/dead) (make-cell 2 2 s/dead)]]]
    (is (= world (sut/tick-world world)))
    (is (= world (sut/tick-world (assoc-in world [1 1 :state] s/alive))))))



(let [world [[(make-cell 0 0 s/dead) (make-cell 1 0 s/dead) (make-cell 2 0 s/dead)]
             [(make-cell 0 1 s/alive) (make-cell 1 1 s/alive) (make-cell 2 1 s/alive)]
             [(make-cell 0 2 s/dead) (make-cell 1 2 s/dead) (make-cell 2 2 s/dead)]]]
  ;;(conways-game-of-life.print-world/print-world (sut/tick-world world))
  ;;(prn "=====================================")
  (conways-game-of-life.print-world/print-world (-> world
                                                    (sut/tick-world)
                                                    (sut/tick-world)
                                                    (sut/tick-world)))
  ;;(prn "=====================================")
  )






