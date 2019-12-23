(ns eboard-testutils.data
  (:require [eboard-domain.Domain :refer :all]))

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

(defn create-contender [citizen] 
  (map->Contender {:id (.toString (java.util.UUID/randomUUID)) 
                   :contender citizen
                   :createdAt currentDateTime
                   :updatedAt currentDateTime}))
