(def transactions
  [{:value 33.0 :type "expense" :comment "Almoço"
    :currency "R$" :date "19/11/2016"}
   {:value 2700.0 :type "revenue" :comment "Bico"
    :currency "R$" :date "01/12/2016"}
   {:value 29.0 :type "expense" :comment "Livro de Clojure"
    :currency "R$" :date "03/12/2016"}])

; scopping with let
(defn flagged-value [transaction] 
  (let [currency (:currency transaction "R$")
        value (:value transaction)]
    (if (= (:type transaction) "despesa")
      (str currency " -" value) (str currency " +" value))))

(flagged-value (first transactions))
(flagged-value (second transactions))
(flagged-value (last transactions))
(map flagged-value (filter expense? transactions))

(defn entry-date-value [transaction]
  (str (:date transaction) " => " (flagged-value transaction)))

(defn dolar-conversion [transaction]
  (assoc transaction :value (* 4.05 (:value transaction))
         :currency "$"))
