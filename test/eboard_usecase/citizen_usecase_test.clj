(ns eboard-usecase.citizen-usecase-test
  (:require [midje.sweet :refer :all]
            [eboard-usecase.citizen-usecase :refer :all]
            [eboard-testutils.data :refer :all]
            ))

(facts "citizen nomites as contender"
       (fact "citizen with age greather than Or equal to voting age should be able to nominate as Contender"
             (def citizen1 (create-citizen "manikandnan" "muthu" 18 "citizen1@test.com"))
             (def contender1 (create-contender citizen1))            
             (citizen-nominates-as-contender contender1)
             (def actualContender (citizen-gets-contender-by (:id contender1)))
             (citizen-gets-contender-by (:id contender1))
              contender1 => actualContender   
        )
        (fact "citizen with age NOT greather than Or equal to voting age should NOT be able to nominate as Contender"
             (def citizen1 (create-citizen "manikandnan" "muthu" 17 "citizen1@test.com"))
             (def contender1 (create-contender citizen1))            
             (citizen-nominates-as-contender contender1)
             (def actualContender (citizen-gets-contender-by (:id contender1)))
             (citizen-gets-contender-by (:id contender1))
              nil => actualContender   
        )
 )