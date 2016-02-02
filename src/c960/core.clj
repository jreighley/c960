(ns  c960.core)

(defn -main []
 ; Build a deck of cards 1 - 8 and shuffle them
(def fulldeck(shuffle(seq(range 1 9 ))))
;First even and first odd card get bishops
(def B1(first (filter even? fulldeck)))
(def B2 (first (filter odd? fulldeck)))
;remove the bishop cards and take the next 3 for Queens and knights
(def Q1 (first (remove (set[B1 B2]) fulldeck)))
(def N1 (nth (remove (set[B1 B2]) fulldeck) 1))
(def N2 (nth (remove (set[B1 B2]) fulldeck) 2))
;remove the cards used by the bishops knights and queens and sort the last 3
;place the Rooks on the outside and the king in the middle of the remaining cards
(def R1 (first(sort(remove (set[B1 B2 N1 N2 Q1]) fulldeck) )))
  (def K1 (nth(sort(remove (set[B1 B2 N1 N2 Q1]) fulldeck) )1))
  (def R2 (nth(sort(remove (set[B1 B2 N1 N2 Q1]) fulldeck) )2))
;print the peice names from 1 to 8
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
