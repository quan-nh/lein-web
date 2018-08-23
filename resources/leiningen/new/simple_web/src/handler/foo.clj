(ns {{namespace}}.handler.foo
  (:require [clojure.spec.alpha :as s]))

(s/fdef bar
        :args (s/cat :id int?)
        :ret string?)

(defn bar [id] (str "greeting " id))
