(ns {{namespace}}.db
  (:require [mount.core :refer [defstate]]
            [{{namespace}}.conf :refer [config]]
            [hikari-cp.core :refer [make-datasource close-datasource]]))

(defstate conn
  :start {:datasource (make-datasource (:db config))}
  :stop (close-datasource (:datasource conn)))
