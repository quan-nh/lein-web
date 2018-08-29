(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [mount "0.1.13"]
                 ;; web
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [compojure "1.6.1"]
                 [metosin/muuntaja "0.6.0-alpha3"]
                 [metosin/ring-http-response "0.9.0"]
                 ;; config
                 [aero "1.1.3"]
                 ;; db
                 [org.clojure/java.jdbc "0.7.8"]
                 [com.h2database/h2 "1.4.197"]
                 [hikari-cp "2.6.0"]
                 ;; logging
                 [org.clojure/tools.logging "0.4.1"]
                 [ch.qos.logback/logback-classic "1.2.3"]]
  :main ^:skip-aot {{namespace}}.main
  :profiles
  {:dev {:source-paths ["dev"]
         :dependencies [[javax.servlet/servlet-api "2.5"]
                        [org.clojure/tools.namespace "0.2.11"]
                        [tolitius/mount-up "0.1.1"]
                        [ragtime "0.7.2"]
                        [orchestra "2018.08.19-1"]]
         :repl-options {:init-ns user}}
   :uberjar {:aot :all}}
  :aliases {"migrate"  ["run" "-m" "user/migrate"]
            "rollback" ["run" "-m" "user/rollback"]})
