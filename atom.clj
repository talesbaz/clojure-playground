(def registers (atom ()))

; will print the registers reference
registers

; print registers content
@registers

(swap! registers conj {:value 33.0 :type "expense" :comment "Almoço"
                       :currency "R$" :date "19/11/2016"})

;; abstract data insert in atom
(defn register [transaction]
  (swap! registers conj transaction))

(register {:value 33.0 :type "expense" :comment "Almoço"
           :currency "R$" :date "19/11/2016"})