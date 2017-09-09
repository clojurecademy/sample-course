(ns clj.helper-fns)


(defn str-join-used?
  [all-forms]
  ((complement not-any?) (fn [form]
                           (and (= 'str/join (first form))
                                (vector? (second form))
                                (= 2 (count (second form)))))
    (filter list? all-forms)))