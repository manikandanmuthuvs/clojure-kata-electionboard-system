(ns eboard-testutils.test-data
  (:require [eboard-domain.Domain :refer :all]
            [eboard-usecase.citizen-usecase-impl :refer :all]
            [eboard-usecase.contender-usecase-impl :refer :all]
            [clojure.data.json :as json]
   )
)

(import java.util.UUID)
(import java.text.DateFormat)
(import java.text.SimpleDateFormat)

(def simpleDateFormat (SimpleDateFormat. "dd/MM/yy HH:mm:ss"))

(def currentDateTime (.format simpleDateFormat (new java.util.Date)))

(def ideas ["Commitment","Empathy","Openness"])
(def idea-repo (atom {}))     

(defn create-citizen [firstName lastName age email] 
  (map->Citizen {:id (.toString (java.util.UUID/randomUUID)) 
                 :firstName firstName 
                 :lastName lastName 
                 :age age 
                 :email email
                 :createdAt currentDateTime
                 :updatedAt currentDateTime}))

(defn create-citizen-usecase []
  (map->CitizenUsecaseImpl {})
)
(defn create-contender-usecase []
  (map->ContenderUsecaseImpl {})
)
(defn create-contender 
	([citizen]
	    (map->Contender {:id (.toString (java.util.UUID/randomUUID)) 
	                  :contender citizen
	                  :createdAt currentDateTime
	                   :updatedAt currentDateTime})
	 )
	  
	([citizen manifesto] 
	  (map->Contender {:id (.toString (java.util.UUID/randomUUID)) 
	                   :contender citizen
	                   :manifesto manifesto
	                   :createdAt currentDateTime
	                   :updatedAt currentDateTime}
	   )
	 )
)
;(defn create-contender [citizen manifesto] 
;  (map->Contender {:id (.toString (java.util.UUID/randomUUID)) 
;                   :contender citizen
;                   :manifesto manifesto
;                   :createdAt currentDateTime
;                   :updatedAt currentDateTime}))


(defn create-idea [idea average-rating rate] 
  (map->Idea {:id (.toString (java.util.UUID/randomUUID)) 
                   :idea idea
                   :average-rating average-rating
                   :rate rate
                   :createdAt currentDateTime
                   :updatedAt currentDateTime}))

(defn create-rate [rating citizen] 
  (map->Idea {:id (.toString (java.util.UUID/randomUUID)) 
                   :rating rating
                   :voter citizen
                   :createdAt currentDateTime
                   :updatedAt currentDateTime}))

(defn create-ideas []
   (for [idea ideas]        
       (let [new-idea (create-idea idea nil nil)]
            (into {} [{(:id new-idea) new-idea}])
       )
	 ) 
)
(defn create-manifesto [number-of-ideas]
  (map->Manifesto {:ideas (create-ideas)})    
)
