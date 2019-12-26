(ns eboard-domain.Domain 
  (:require [eboard-protocol.citizen-usecase-protocol :refer :all])
)

(defrecord Contender [id contender manifesto])
(defrecord Citizen [id firstName lastName age email])
(defrecord Manifesto [ideas])
(defrecord Idea [id idea average-rating rate])
(defrecord Rate [id rating voter])
(defrecord Follower [id citizen])