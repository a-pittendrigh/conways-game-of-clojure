(ns conways-game-of-life.print-world
  (:require [conways-game-of-life.statuses :as s]))

(defn print-world [world]
  (let [cell->char (fn [{state :state}] (if (= state s/dead) "" "*"))
        map-row #(map cell->char %)]
      (map #(prn (map-row %)) world)))
