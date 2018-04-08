(ns leiningen.new.simple-web
  (:require [leiningen.core.main :as main]
            [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]))

(def render (renderer "simple-web"))

(defn simple-web
  "Create a new web project"
  [name]
  (let [main-ns (sanitize-ns name)
        data    {:raw-name    name
                 :name        (project-name name)
                 :namespace   main-ns
                 :dirs        (name-to-path main-ns)
                 :year        (year)}]
    (->files data
             [".gitignore"   (render "gitignore")]
             ["project.clj"  (render "project.clj" data)]
             ["README.md"    (render "README.md" data)]
             "db"
             ["dev/dev.clj"  (render "dev/dev.clj" data)]
             ["dev/user.clj" (render "dev/user.clj")]
             ["resources/config.edn"  (render "resources/config.edn")]
             ["resources/logback.xml" (render "resources/logback.xml")]
             "resources/sql"
             "resources/public"
             ["src/{{dirs}}/conf.clj" (render "src/conf.clj" data)]
             ["src/{{dirs}}/db.clj"   (render "src/db.clj" data)]
             ["src/{{dirs}}/main.clj" (render "src/main.clj" data)]
             ["src/{{dirs}}/www.clj"  (render "src/www.clj" data)]
             "src/{{dirs}}/db"
             "src/{{dirs}}/handler")))
