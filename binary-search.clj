;;binary-search
(defn binary-search [ls target]
  (loop [loop-ls ls]
    (let [ split-in-half (split-at (/ (count loop-ls) 2) loop-ls)
           [first-half second-half] split-in-half
           guess (peek (vec first-half))]
       (cond
          (empty? second-half) "not found"
          (= 0 (compare target guess)) (str "found " target " At index: " (.indexOf ls target))
          (< 0 (compare target guess)) (recur first-half)
          (> 0 (compare target guess)) (recur second-half)))))
