(ns calorie_calculator.routes
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :refer [wrap-json-body
                                          wrap-json-response]]
            [calorie_calculator.handlers :as handlers]))

(defroutes app-routes

  (POST "/user" req
    {:status 200
     :body (handlers/register-user (:body req))})

  (POST "/food" req
    {:status 200
     :body (handlers/register-food (:body req))})

  (POST "/exercise" req
    {:status 200
     :body (handlers/register-exercise (:body req))})

  (GET "/transactions/:start/:end"
    [start end]

    {:status 200
     :body (handlers/get-transactions start end)})

  (GET "/balance/:start/:end"
    [start end]

    {:status 200
     :body {:balance
            (handlers/get-balance start end)}})

  (route/not-found
   {:status 404
    :body {:error "Rota não encontrada"}}))

(def app
  (-> app-routes
      (wrap-json-body {:keywords? true})
      wrap-json-response))
