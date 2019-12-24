(ns eboard-usecase.citizen-usecase-test
  (:require [midje.sweet :refer :all]
            [eboard-usecase.citizen-usecase-impl :refer :all]
            [eboard-protocol.citizen-usecase-protocol :refer :all]
            [eboard-testutils.test-data :refer :all]
   )
 )

(facts "citizen nominates as contender"
       (fact "citizen with age greather than Or equal to voting age should be able to nominate as Contender"
             (def citizen1 (create-citizen "manikandnan" "muthu" 18 "citizen1@test.com"))
             (def contender1 (create-contender citizen1))   
             (def citizen-usecase (create-citizen-usecase))
             (def citi (citizen-nominates-as-contender citizen-usecase contender1))
;             (println (str "printing id of contender: " (:id contender1)))
             (def actualContender (citizen-gets-contender-by citizen-usecase (:id contender1)))
              contender1 => actualContender   
        )
     (fact "citizen with age NOT greather than Or equal to voting age should NOT be able to nominate as Contender"
           (def citizen1 (create-citizen "manikandnan" "muthu" 17 "citizen1@test.com"))
           (def contender1 (create-contender citizen1))   
           (def citizen-usecase (create-citizen-usecase))
           (def citi (citizen-nominates-as-contender citizen-usecase contender1))
;           (println (str "printing id of contender: " (:id contender1)))
           (def actualContender (citizen-gets-contender-by citizen-usecase (:id contender1)))
            actualContender => nil   
       )
 )