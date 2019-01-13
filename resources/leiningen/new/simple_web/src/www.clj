(ns {{namespace}}.www
  (:require [mount.core :refer [defstate]]
            [{{namespace}}.conf :refer [config]]
            [{{namespace}}.handler.foo :as foo-handler]
            [compojure.core :refer :all]
            [compojure.coercions :refer :all]
            [compojure.route :as route]
            [muuntaja.middleware :as mw]
            [ring.adapter.jetty :refer [run-jetty]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/req" req (str req))
  (GET "/foo/:id" [id :<< as-int] (foo-handler/bar id))
  (route/not-found "Not Found"))

(defstate app
  :start (-> app-routes
             mw/wrap-format
             (run-jetty {:join? false
                         :port (get-in config [:www :port])}))
  :stop (.stop app))
