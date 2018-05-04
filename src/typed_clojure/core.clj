(ns typed-clojure.core
  {:lang :core.typed}
  (:gen-class)
  (:require [clojure.core.typed :refer [ann defalias ann-datatype] :as t]
            [mount.core :refer [defstate] :as mount]))

(ann-datatype ^:no-check mount.core.DerefableState [name :- String])

(defalias Userid (t/U (t/Option String) mount.core.DerefableState))

(ann ^:no-check mount.core/running-noop? [t/Any -> t/Any])
(ann ^:no-check mount.core/mount-it [t/Any t/Any t/Any -> t/Any])
(ann ^:no-check mount.core/current-state [t/Any -> Userid])
(ann ^:no-check mount.core/start [-> t/Nothing])
(ann ^:no-check mount.core/stop [-> t/Nothing])

(ann userid Userid)
(defstate userid
  :start "10000"
  :stop nil)

(defalias User '{:userid Userid
                 :name String})

(ann get-userid [User -> Userid])
(defn get-userid [user]
  (:userid user))

(defn -main []
  (mount/start)
  (let [user {:userid userid :name "Eunmin Kim"}]
    (println "userid:" (get-userid user)))
  (mount/stop))
