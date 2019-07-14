(ns conways-game-of-life.tick-world
  (:require [conways-game-of-life.tick-cell :as cell]))

(defn tick-world [world]
  (let [map-row (fn [row] (mapv #(-> %
                                    (living-neighbours world)
                                    ((fn [n] (cell/tick-cell % n))))
                                row))]
    (mapv map-row world)))

