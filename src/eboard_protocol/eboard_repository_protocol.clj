(ns eboard-protocol.eboard-repository-protocol)

(defprotocol EBoardRepository
  (create [_ contender])
;  (post [contenderId manifesto])
  (find-by [_ contenderId])
  ;(get-repository [])
)