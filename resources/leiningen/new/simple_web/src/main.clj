(ns {{namespace}}.main
  (:gen-class)
  (:require [mount.core :as mount]
            {{namespace}}.www))

(defn -main [& args]
  (mount/start))
