(defproject typed-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.typed "0.5.1"]
                 [mount "0.1.12"]]
  :profiles {:uberjar {:aot :all}}
  :injections [(require 'clojure.core.typed) (clojure.core.typed/install)]
  :main ^:skip-aot typed-clojure.core)
