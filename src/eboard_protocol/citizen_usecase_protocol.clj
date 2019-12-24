(ns eboard-protocol.citizen-usecase-protocol
)

(defprotocol CitizenUsecase
 (citizen-nominates-as-contender [_ citizen])
 (citizen-gets-contender-by [_ contenderId])
)