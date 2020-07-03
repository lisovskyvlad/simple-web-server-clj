(ns tutorial1.core
  (:require [ring.adapter.jetty :as jetty]
            [clojure.pprint :as pp]))

(defn handler [request]
  ;;(pp/pprint request)
  (pp/pprint (:remote-addr request))
  (pp/pprint (:headers request))
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello World"})

(defn create-http-server []
  (jetty/run-jetty handler {:port 8082, :join? false, :async true}))
