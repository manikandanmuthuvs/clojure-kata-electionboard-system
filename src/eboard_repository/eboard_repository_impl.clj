(ns eboard-repository.eboard-repository-impl
  (:require [eboard-protocol.eboard-repository-protocol :refer :all])
)

(def EBoard-Repository (atom {})
)

(defrecord EboardRepositoryImpl []
  EBoardRepository
  (create [_ contender] 
    (def contenderId (:id contender))
    (swap! EBoard-Repository assoc (str ":" contenderId ) contender)
   )
;  (post [contenderId manifesto] 
;	  (swap! EBoard-Repository assoc contenderId manifesto)
;  )
  (find-by [_ contenderId]
    (get-in @EBoard-Repository [contenderId])
  )
 ; (get-repository [] @EBoard-Repository)
)
