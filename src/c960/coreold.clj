(ns c960.core)
(declare Q1)
(declare N1)
(def diceque (repeatedly 50 #(+ 1 (rand-int 8)))) ; roll a dice 50 times

(defn -main []
  ;first bishop goes on the even square
(if (even? (first diceque))
  (def B2 (first diceque))
  (def B2 (inc (first diceque) )))
(def diceque (rest diceque))

;second bishop goes on the odd square
(if (odd? (first diceque))
  (def B1 (first diceque))
  (def B1 (dec (first diceque) )))
(def diceque (rest diceque))
;Queen goes on the next open random square
(while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1))
  (def diceque (rest diceque))
  )
(def Q1 (first diceque))
;knights go on open random squares
(while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1))
  (def diceque (rest diceque))
  )
(def N1 (first diceque))
(while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1))
  (def diceque (rest diceque))
  )
(def N2 (first diceque))

;dump the random dice queue  and replace it with one that works from left to right
(def diceque '(1 2 3 4 5 6 7 8))

;Rook goes on first open space
  (while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1)(= (first diceque) N2))
  (def diceque (rest diceque))
  )
(def R1 (first diceque))
  (def diceque (rest diceque))
;king goes on the second open space
  (while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1)(= (first diceque) N2))
  (def diceque (rest diceque))
  )
(def K1 (first diceque))
  (def diceque (rest diceque))
;Rook goes on the last open space
  (while (or (= (first diceque) B1)(= (first diceque) B2)(= (first diceque) Q1) (= (first diceque) N1)(= (first diceque) N2))
  (def diceque (rest diceque))
  )
(def R2 (first diceque))

;Now we put them in order and print them out.
  (def peiceseq(for [nxtsquare (range 1 9)]
  (cond
   (= Q1 nxtsquare) "Q"
   (= B1 nxtsquare) "B"
   (= B2 nxtsquare) "B"
   (= N1 nxtsquare) "N"
   (= N2 nxtsquare) "N"
   (= R1 nxtsquare) "R"
   (= R2 nxtsquare) "R"
   (= K1 nxtsquare) "K"
)))
 (println peiceseq)
  )
