(ns calorie-calculator.calories
  (:require [clojure.string :as str]))

(def food-calories
  {"maca" 52
   "banana" 89
   "arroz" 130
   "feijao" 347
   "frango" 165
   "pizza" 300})

(def exercise-calories
  {"corrida" 600
   "caminhada" 300
   "natacao" 500
   "ciclismo" 400})

(defn fetch-food-calories [food]
  (get food-calories
       (str/lower-case food)
       100))

(defn fetch-exercise-calories [exercise]
  (get exercise-calories
       (str/lower-case exercise)
       200))

(defn calculate-food-calories [food quantity]
  (* (fetch-food-calories food)
     (/ quantity 100.0)))

(defn calculate-exercise-calories [exercise duration]
  (* (fetch-exercise-calories exercise)
     (/ duration 60.0)))
