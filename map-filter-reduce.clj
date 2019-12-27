(defn summary [transaction]
  (select-keys transaction [:value :type]))

(def transactions
  [{:value 33.0 :type "expense" :comentario "Almoço" :date "19/11/2016"}
   {:value 2700.0 :type "revenue" :comentario "Bico" :date "01/12/2016"}
   {:value 29.0 :type "expense" :comentario "Livro de Clojure" :date "03/12/2016"}])

; list some fields of transactions
(map summary transactions)

(defn expense? [transaction]
  (= (:type transaction) "expense"))

; filter just expense transactions
(filter expense? transactions)

(defn get-value [transaction]
  (:value transaction))

; Get expense values
(map get-value (filter expense? transactions))

; Wrapper
(defn get-expense-values [transactions]
  (map get-value (filter expense? transactions)))

; Sum expenses
(reduce +(get-expense-values transactions))