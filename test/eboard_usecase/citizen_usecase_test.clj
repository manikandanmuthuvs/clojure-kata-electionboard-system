(ns eboard-usecase.citizen-usecase-test
  (:require [midje.sweet :refer :all]
            [eboard-usecase.citizen-usecase-impl :refer :all]
            [eboard-protocol.citizen-usecase-protocol :refer :all]
            [eboard-usecase.contender-usecase-impl :refer :all]
            [eboard-protocol.contender-usecase-protocol :refer :all]
            [eboard-testutils.test-data :refer :all]
            [clojure.data.json :as json]
   )
 )

(facts "citizen nominates as contender"
       (fact "citizen with age greather than Or equal to voting age should be able to nominate as Contender"
             (def citizen-1 (create-citizen "manikandnan" "muthu" 18 "citizen1@test.com"))
             (def contender-1 (create-contender citizen-1))   
             (def citizen-usecase (create-citizen-usecase))
             (citizen-nominates-as-contender citizen-usecase contender-1)
             (def contender-id (str ":" (:id contender-1)))
             (def actual-contender (citizen-gets-contender-by citizen-usecase contender-id))
             ;(println (json/write-str actual-contender)); 
             contender-1 => actual-contender   
       )
	     (fact "citizen with age NOT greather than Or equal to voting age should NOT be able to nominate as Contender"
	           (def citizen-1 (create-citizen "manikandnan" "muthu" 17 "citizen1@test.com"))
             (def contender-1 (create-contender citizen-1))   
             (def citizen-usecase (create-citizen-usecase))
             (citizen-nominates-as-contender citizen-usecase contender-1)
             (def contender-id (str ":" (:id contender-1)))
             (def actual-contender (citizen-gets-contender-by citizen-usecase contender-id))
             ;(println (json/write-str actual-contender)); 
             actual-contender => nil      
	       )     
	      (fact "citizen gets all contenders and their manifesto"
	           (def citizen-1 (create-citizen "manikandnan" "muthu" 18 "citizen1@test.com"))
	           (def contender-1 (create-contender citizen-1))   
	           (def citizen-usecase (create-citizen-usecase))
	           (citizen-nominates-as-contender citizen-usecase contender-1)
	           (def NUMBER-OF-IDEAS-IN-MANIFESTO 3)
	           (def manifesto (create-manifesto NUMBER-OF-IDEAS-IN-MANIFESTO))
	           (def contender-usecase (create-contender-usecase))
	           (def contender-id (str ":" (:id contender-1)))
	           (contender-post-manifesto contender-usecase contender-id manifesto)
	           (def actual-contender (citizen-gets-contender-by citizen-usecase contender-id))
	           (def actual-manifesto (get-in actual-contender [:manifesto])) 
;	           (println (json/write-str actual-manifesto))
;             (println (json/write-str manifesto)) 
 	           (json/write-str actual-manifesto) => (json/write-str manifesto)  
	       )
 )