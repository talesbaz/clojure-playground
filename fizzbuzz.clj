(defn divisible-for? [dividend divider]
  (zero? (mod dividend divider)))

(defn fizzbuzz [number]
  (cond (and (divisible-for? number 3)
             (divisible-for? number 5)) "fizzbuzz" 
        (divisible-for? number 3) "fizz" 
        (divisible-for? number 5) "buzz"
        :else number))