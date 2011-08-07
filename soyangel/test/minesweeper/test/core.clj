(ns minesweeper.test.core
  (:use [minesweeper.core])
  (:use [clojure.test]))

(deftest read-single-field
  (is (= [[".*"]]
         (read-fields "1 2\n.*\n"))))

(deftest read-two-fields
  (is (= [[".*"] ["." "*"]]
         (read-fields "1 2\n.*\n2 1\n.\n*\n"))))

(deftest get-pos-test
  (is (= \*
         (get-pos ["." "*"] 0 1)))
  (is (= \.
         (get-pos ["." "*"] 0 0))))

(deftest adjacent-mines-test
  (is (= 0
         (adjacent-mines ["..."] 0 0)))
  (is (= 1
         (adjacent-mines [".*."] 0 0)))
  (is (= 2
         (adjacent-mines [".*." "..." "..*"] 1 1)))
  (is (= 4
         (adjacent-mines [".*.." ".*.*" "**.."] 2 1)))
  (is (= 3
         (adjacent-mines ["***" "***" "***"] 2 0)))
  )

(deftest minefield-string-test
  (is (= "Field #1:\n111\n1*1\n"
         (minefield-string 1 ["..." ".*."])))
  (is (= "Field #2:\n1*21\n112*\n"
         (minefield-string 2 [".*.." "...*"])))
  )

(deftest minefields-string-test
  (is (=  "Field #1:\n23*\n**2\n\nField #2:\n*10\n110\n"
          (minefields-string [["..*" "**."] ["*.." "..."]])))
  )


(deftest minesweeper-test
    (is (= "Field #1:\n*100\n2210\n1*10\n1110\n\nField #2:\n**100\n33200\n1*100\n"
           (minesweeper "4 4\n*...\n....\n.*..\n....\n3 5\n**...\n.....\n.*...\n0 0"))))
