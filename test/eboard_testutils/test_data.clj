(ns eboard-testutils.test-data
  (:require [eboard-domain.Domain :refer :all]
            [eboard-usecase.citizen-usecase-impl :refer :all]
   )
)

(import java.util.UUID)
(import java.text.DateFormat)
(import java.text.SimpleDateFormat)

(def simpleDateFormat (SimpleDateFormat. "dd/MM/yy HH:mm:ss"))

(def currentDateTime (.format simpleDateFormat (new java.util.Date)))

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
;(defn create-repository []
;  (map->EboardRepositoryImpl {})
;)
(defn create-contender [citizen] 
  (map->Contender {:id (.toString (java.util.UUID/randomUUID)) 
                   :contender citizen
                   :createdAt currentDateTime
                   :updatedAt currentDateTime}))

;(defn create-manifesto [ideas]
;  (map->Manifesto {:ideas ideas})
; )
