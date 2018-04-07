(ns {{namespace}}.conf
  (:require [mount.core :refer [defstate]]
            [clojure.java.io :as io]
            [clojure.edn :as edn]))

(defstate config
  :start (-> (io/resource "config.edn") slurp edn/read-string))
