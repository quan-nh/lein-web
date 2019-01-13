(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [mount "0.1.15"]
                 ;; web
                 [ring/ring-core "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [compojure "1.6.1"]
                 [metosin/muuntaja "0.6.3"]
                 [metosin/ring-http-response "0.9.1"]
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
                        [tolitius/mount-up "0.1.2"]
                        [ragtime "0.8.0"]
                        [orchestra "2018.12.06-2"]]
         :repl-options {:init-ns user}}
   :uberjar {:aot :all}}
  :aliases {"migrate"  ["run" "-m" "user/migrate"]
            "rollback" ["run" "-m" "user/rollback"]})
