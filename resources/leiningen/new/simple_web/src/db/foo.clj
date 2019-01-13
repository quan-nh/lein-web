(ns {{namespace}}.db.foo
  (:require [{{namespace}}.db :as db]
            [clojure.java.jdbc :as jdbc]))

(defn find-by-id [id]
  (first (jdbc/query db/conn ["SELECT id, name FROM foo WHERE id = ?" id])))
