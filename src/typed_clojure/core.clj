(ns typed-clojure.core
  {:lang :core.typed}
  (:require [clojure.core.typed :refer [ann defalias] :as t]))

(defalias User '{:daumid (t/Option String)
                 :userid String})

(ann f [Long Long -> Long])
(defn f [x y]
  (+ x y))

(ann get-userid [User -> String])
(defn get-userid [user]
  (:userid user))

(defn -main []
  (let [user {:userid "1" :daumid nil}]
    (println "userid:" (get-userid user))))
