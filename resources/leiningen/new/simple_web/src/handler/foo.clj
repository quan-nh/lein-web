(ns {{namespace}}.handler.foo
  (:require [clojure.spec.alpha :as s]
            [ring.util.http-response :refer :all]
            [{{namespace}}.db.foo :as foo-db]))

(s/fdef bar
        :args (s/cat :id int?)
        :ret map?)

(defn bar [id] (ok (foo-db/find-by-id id)))
