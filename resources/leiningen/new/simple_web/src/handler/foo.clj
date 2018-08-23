(ns {{namespace}}.handler.foo
  (:require [clojure.spec.alpha :as s]
            [ring.util.http-response :refer :all]
            [{{namespace}}.db.bar :refer [find-bar]]))

(s/fdef bar
        :args (s/cat :id int?)
        :ret map?)

(defn bar [id] (ok (find-bar id)))
