(ns clj.helper-fns)


(defn str-join-used?
  [codes]
  ((complement not-any?) (fn [code]
                           (and (= 'str/join (first code))
                                (vector? (second code))
                                (= 2 (count (second code)))))
    (filter list? codes)))