(ns advent.day2.part1
  (:gen-class))

(require '[clojure.string :as str])

(defn parse-line [line]
  (let [vals (str/split line #"[\- :]")]
    (list (get vals 0) (get vals 1) (get vals 2) (get vals 4))
    )
  )

(defn valid-password? [lower upper c pw]
  (let [cnt (frequencies pw)
        f (get cnt (.charAt c 0) 0)]
    (and (>= f (Integer. lower)) (<= f (Integer. upper)))
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
