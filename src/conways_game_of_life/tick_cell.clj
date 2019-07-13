(ns conways-game-of-life.tick-cell
  (:require [conways-game-of-life.statuses :as status]))

(defn get-if-alive [x y world]
  (let [cell (get-in world [y x])]
    (prn cell (= status/alive (:state cell)) x y)
    (when (= status/alive (:state cell))
      cell)))

(defn neighbours [{:keys [x y] :as cell} world]
  (let [at (fn [x y] (get-in world [y x]))
        above (get-in world [(- y 1) x] world)
        beneath (get-in world [(+ y 1) x] world)
        top-left (get-in world [(- y 1) (- x 1) ])
        top-right (get-in world [(- y 1) (+ x 1)])
        left (at (- x 1) y)
        right (at (+ x 1) y)
        this nil
        bot-left (at (- x 1) (+ y 1))
        bot-right (at (+ x 1) (+ y 1))]
    [top-left above   top-right
     left     this    right
     bot-left beneath bot-right]))

(defn living-neighbours [cell world]
  (->> (neighbours cell world)
       (filter #(and (not (nil? %)) (= status/alive (:state %))))))

(defmulti tick-cell
  (fn [cell living-neighbours] (:state cell)))

(defmethod tick-cell status/dead [cell living-neighbours]
  (let [num-living-neighbours (count living-neighbours)]
    (cond
      (= 3 num-living-neighbours) (assoc cell :state status/alive)
      :default cell)))

(defmethod tick-cell status/alive [{:keys [x y] :as cell} living-neighbours]
  (let [num-living-neighbours (count living-neighbours)]
    (cond
      (< num-living-neighbours 2) (assoc cell :state status/dead)
      (<= num-living-neighbours 3) cell
      (< 3 num-living-neighbours) (assoc cell :state status/dead))))
