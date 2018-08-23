(ns {{namespace}}.db.bar
  (:require [{{namespace}}.db :as db]
            [clojure.java.jdbc :as jdbc]))

(defn find-bar [id]
  (first (jdbc/query db/conn (str "SELECT " id))))
