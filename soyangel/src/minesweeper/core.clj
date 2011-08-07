(ns minesweeper.core
  (:require [clojure.string :as str]))

(def neighbours [[0 -1] [1 -1] [1 0] [1 1] [0 1] [-1 1] [-1 0] [-1 -1]])

(defn is-size-line? [line]
  (re-matches #"\d+ \d+" line))

(defn add-to-results [col line]
  (if (is-size-line? line)
    (if (= "0 0" line)
      col
      (conj (vec col) []))
    (let [last-elem (conj (vec (last col)) line)]
     (conj (vec (drop-last col)) last-elem))))

(defn read-fields [st]
  (let [lines (seq (.split st "\n"))]
    (reduce add-to-results [] lines)))

(defn get-pos [field x y]
  (nth (nth field y ".") x \.))

(defn field-rows [field]
  (count field))

(defn field-columns [field]
  (count (first field)))

(defn is-mine? [field  x y]
  (= \* (get-pos field x y)))

(defn adjacent-mines [field x y]
  (let [positions (map #(map + [x y] %) neighbours)
        neighbour-values (map #(apply get-pos field %) positions)]
    (count (filter #(= \* %) neighbour-values))))

(defn mine-count-field [field]
  (for [y (range (field-rows field))]
    (apply str 
           (for [x (range (field-columns field))]
             (if (is-mine? field x y)
               \*
              (adjacent-mines field x y))))))

(defn minefield-string [number field]
  (let [minefield (mine-count-field field)
        first-line (format "Field #%d:\n" number)]
     (str first-line (str/join "\n" minefield) "\n")))

(defn minefields-string [fields]
  (str/join "\n" (map #(minefield-string %1 %2)
                 (range 1 (inc (count fields)))
                 fields)))

(defn minesweeper [field-string]
  (minefields-string (read-fields field-string)))


