(ns calorie_calculator.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [calorie_calculator.routes :refer [app]])
  (:gen-class))

(defn start-server []

  (run-jetty
   app
   {:port 3000
    :join? false}))

(defn -main [& args]

  (println "Servidor iniciado na porta 3000")

  (start-server))