(ns eboard-repository.contender-repository
  (:require [clojure.data.json :as json]))

;(def Contender-Repository (. clojure.lang.PersistentHashMap create {}))
(def Contender-Repository (atom {})
)

(defn create-contender [contender] 
  (def contenderId (:id contender))
  (swap! Contender-Repository assoc (str ":" contenderId ) contender)
)

(defn find-contender-by [contenderId]
  (get-in @Contender-Repository [contenderId])
)

(defn display-repository-as-json []
  (println Contender-Repository)
)