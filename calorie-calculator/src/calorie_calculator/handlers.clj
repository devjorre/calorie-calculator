(ns calorie-calculator.handlers
  (:require [calorie-calculator.db :refer [database]]
            [calorie-calculator.calories :as calories]))

(defn register-user [body]

  (swap! database assoc :user body)

  {:message "Usuário cadastrado com sucesso"})

(defn register-food [body]

  (let [total-calories
        (calories/calculate-food-calories
         (:name body)
         (:quantity body))

        transaction
        {:type :food
         :name (:name body)
         :date (:date body)
         :quantity (:quantity body)
         :calories total-calories}]

    (swap! database update :transactions conj transaction)

    transaction))

(defn register-exercise [body]

  (let [total-calories
        (calories/calculate-exercise-calories
         (:name body)
         (:duration body))

        transaction
        {:type :exercise
         :name (:name body)
         :date (:date body)
         :duration (:duration body)
         :calories total-calories}]

    (swap! database update :transactions conj transaction)

    transaction))

(defn filter-by-period [start end transactions]

  (filter
   (fn [t]
     (and
      (>= (compare (:date t) start) 0)
      (<= (compare (:date t) end) 0)))

   transactions))

(defn get-transactions [start end]

  (filter-by-period
   start
   end
   (:transactions @database)))

(defn get-balance [start end]

  (reduce
   (fn [acc t]

     (if (= (:type t) :food)
       (+ acc (:calories t))
       (- acc (:calories t))))

   0
   (get-transactions start end)))
