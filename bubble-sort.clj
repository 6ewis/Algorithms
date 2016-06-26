;;bubble algorithm

(defn swap-elements [element-a element-b coll]
     (let [index-a (.indexOf coll element-a)
           index-b (.indexOf coll element-b)]
        (assoc coll index-b (coll index-a) index-a (coll index-b))))

(defn min-val-in-first-position [[x & more :as all]]
  (loop [loop-ls all loop-rest more]
    (let [first-position (first loop-ls)
          next-position (first loop-rest)]
      (if (empty? loop-rest)
        loop-ls
        (if (< first-position next-position)
          (recur loop-ls (rest loop-rest))
          (recur (swap-elements first-position next-position loop-ls) (rest loop-rest)))))))

(defn bubble-sort [ls]
  (loop [loop-ls ls loop-rest ls last-sorted []]
    (let [[y & more-y] loop-ls
          sorted (conj last-sorted y)]
      (if (= 1 (count loop-rest))  
        sorted
        (recur (min-val-in-first-position (vec more-y)) (rest loop-rest) sorted)))))
