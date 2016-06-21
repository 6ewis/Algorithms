;;Version one
;; the classic selection sort modifies in place, however this version is making multiple passes over the collections 
;; one to find the min, one to remove the min, and essentially one to concatenate the rest onto the first part after the split, so it’s not very efficient
(defn remove-one [item list]
  (let [[n m] (split-with (partial not= item) list)] (vec (concat n (rest m))))) 
       
(defn selection-sort-1 [unsorted]
   (loop [inner-unsorted unsorted sorted []]
     (let [min-val (apply min inner-unsorted)]
       (if 
         (or 
           (= 1 (count inner-unsorted)) 
           (empty? inner-unsorted))
         sorted
         (recur (remove-one min-val inner-unsorted) (conj sorted min-val))))))
