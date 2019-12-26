(ns eboard-protocol.eboard-repository-protocol)

(defprotocol EBoardRepository
  (create [_ contender])
  (post [_ contender-id manifesto])
  (find-by [_ contenderId])
  ;(get-repository [])
)