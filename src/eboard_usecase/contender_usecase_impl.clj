(ns eboard-usecase.contender-usecase-impl
   (:require [eboard-protocol.contender-usecase-protocol :refer :all]
            [eboard-protocol.eboard-repository-protocol :refer :all]
            [eboard-repository.eboard-repository-impl :refer :all]
           )  
)

(defrecord ContenderUsecaseImpl []
   ContenderUsecase
   (contender-post-manifesto [_ contender-id manifesto]    
     (post (create-repository) contender-id manifesto)
   )
)
