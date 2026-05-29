(defproject calorie-calculator "0.1.0-SNAPSHOT"
  :description "Calculadora de calorias"

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.12.1"]
                 [ring/ring-jetty-adapter "1.12.1"]
                 [compojure "1.7.1"]
                 [cheshire "5.12.0"]
                 [ring/ring-json "0.5.1"]
                 [clj-http "3.12.3"]]

  :main calorie_calculator.core
  :aot [calorie_calculator.core])