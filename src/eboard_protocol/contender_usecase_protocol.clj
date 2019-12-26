(ns eboard-protocol.contender-usecase-protocol
)

(defprotocol ContenderUsecase
 (contender-post-manifesto [_ contender-id manifesto])
)