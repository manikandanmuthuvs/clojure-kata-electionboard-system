(ns eboard-domain.Domain)

(defrecord Contender [id contender])
(defrecord Citizen [id firstName lastName age email])