(ns  c960.core)

(def pclist ["Bishop " "Bishop " "Knight " "Knight " "Queen " "Rook " "King " "Rook "])

(defn c960 [] "returns a quasi-random 8 number sequence insuring that the first item is even,the second item is odd and the last 3 items are sorted ascending"
              (let [c960seq (shuffle (range 1 9))
                    oddBish (first (filter odd? c960seq))
                    evenBish (first (filter even? c960seq))
                    goodseq  (->> c960seq
                              (filter #(not= evenBish %))
                              (filter #(not= oddBish %)))]
                (flatten (conj [evenBish oddBish]
                               (take 3 goodseq)
                               (sort (take-last 3 goodseq))))))

(defn buildc960 [] "correlates positions for chess peices to the generated list"
                (->> pclist
                   (zipmap (c960))
                   (sort)
                   (vals)))
                   
(defn -main []
  (println (buildc960)))
