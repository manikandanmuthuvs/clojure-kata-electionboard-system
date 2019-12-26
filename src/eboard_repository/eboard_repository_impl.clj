(ns eboard-repository.eboard-repository-impl
  (:require [eboard-protocol.eboard-repository-protocol :refer :all])
)

(def EBoard-Repository (atom {})
)
(defn get-manifesto [manifesto]
  manifesto
  )
(defrecord EboardRepositoryImpl []
  EBoardRepository
  (create [_ contender] 
    (def contender-id (:id contender))
    (swap! EBoard-Repository assoc (str ":" contender-id ) contender)
          ; (println "printing... contender after creating contender" @EBoard-Repository)
   )
  (post [_ contender-id manifesto]
       (def contender (find-by _ contender-id))
       (def update-contender (update-in contender [:manifesto] merge manifesto))
       (swap! EBoard-Repository update-in [contender-id] merge update-contender)
  )
  (find-by [_ contender-id]
    (get-in @EBoard-Repository [contender-id])
  )
  ;(get-repository [] @EBoard-Repository)
)

(defn create-repository []
    (map->EboardRepositoryImpl {})
 )