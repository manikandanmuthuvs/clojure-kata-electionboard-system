(ns eboard-usecase.citizen-usecase
  (:require [eboard-repository.contender-repository :refer :all]
            [eboard-repository.contender-repository :refer :all]))

(def MAX_VOTING_AGE 18)

(defn citizen-nominates-as-contender [contender]
	 (def contenderAge (get-in contender [:contender :age]))
	 (if (>= contenderAge MAX_VOTING_AGE)
	     (create-contender contender)
    )	 
)
(defn citizen-gets-contender-by [contenderId]
 (find-contender-by (str ":" contenderId))
)