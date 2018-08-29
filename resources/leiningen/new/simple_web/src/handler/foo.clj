(ns {{namespace}}.handler.foo
  (:require [clojure.spec.alpha :as s]
            [ring.util.http-response :refer :all]
            [{{namespace}}.db.foo :refer [find-by-id]]))

(s/fdef bar
        :args (s/cat :id int?)
        :ret map?)

(defn bar [id] (ok (find-by-id id)))
