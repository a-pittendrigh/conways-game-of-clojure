(ns conways-game-of-life.cell
  (:require [conways-game-of-life.statuses :refer [dead]]))

(defn make-cell
  ([x y] (make-cell x y dead))
  ([x y state] {:x x :y y :state state}))
