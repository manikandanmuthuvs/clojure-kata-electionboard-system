(ns eboard-domain.Domain 
  (:require [eboard-protocol.citizen-usecase-protocol :refer :all])
)

(defrecord Contender [id contender])
(defrecord Citizen [id firstName lastName age email])
(defrecord Manifesto [ideas])