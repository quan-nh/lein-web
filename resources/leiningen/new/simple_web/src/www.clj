(ns {{namespace}}.www
  (:require [mount.core :refer [defstate]]
            [{{namespace}}.conf :refer [config]]
            [{{namespace}}.db :as db]
            [clojure.java.jdbc :as jdbc]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/db" [] (jdbc/query db/conn "SELECT 0"))
  (route/not-found "Not Found"))

(defstate app
  :start (-> app-routes
             (run-jetty {:join? false
                         :port (get-in config [:www :port])}))
  :stop (.stop app))
