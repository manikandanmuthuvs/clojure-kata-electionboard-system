(ns eboard-usecase.citizen-usecase-impl
  (:require [eboard-protocol.citizen-usecase-protocol :refer :all]
            [eboard-protocol.eboard-repository-protocol :refer :all]
            [eboard-repository.eboard-repository-impl :refer :all]
           )
 )

(def eboardRepository (create-repository))

(def MAX_VOTING_AGE 18)

(defrecord CitizenUsecaseImpl []
   CitizenUsecase
	  (citizen-nominates-as-contender [_ contender]
       (def contenderAge (get-in contender [:contender :age]))
       (if (>= contenderAge MAX_VOTING_AGE)
         	 (create eboardRepository contender)	 
       )        
	  )
    (citizen-gets-contender-by [_ contender-id]    
      (find-by eboardRepository contender-id)
	  )
)

