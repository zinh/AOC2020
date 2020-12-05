(ns advent.day2.part2
  (:gen-class))

(require '[clojure.string :as str])

(defn parse-line [line]
  (let [vals (str/split line #"[\- :]")]
    (list 
      (Integer. (get vals 0))
      (Integer. (get vals 1))
      (.charAt (get vals 2) 0)
      (get vals 4))
    )
  )

(defn valid-password? [lower upper c pw]
  (let [c1 (.charAt pw (- lower 1))
        c2 (.charAt pw (- upper 1))]
    (cond
      (and (= c1 c) (= c2 c)) false
      (and (not= c1 c) (= c2 c)) true
      (and (= c1 c) (not= c2 c)) true
      :else false
      )
    )
  )

(defn count-line [memo line]
  (let [params (parse-line line)]
    (if (apply valid-password? params)
      (+ memo 1)
      memo
      )
    )
  )

(defn lines []
  (with-open [rdr (clojure.java.io/reader "input")]
    (reduce count-line 0 (line-seq rdr))))

(println (lines))
