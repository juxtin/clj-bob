(ns clj-bob.repl
  "a convenience namespace for CIDER, Fireplace, Cursive etc."
  (:refer-clojure :exclude [cons if num + < atom bound? var?])
  (:require [clj-bob.lang :refer :all]
            [clj-bob.j-bob :refer :all]
            [clj-bob.little-prover :as book]))

;; Experiment below
;; ------------------------------------------------------------

(comment
  (car (cons 'ham '(eggs)))
  ;; ham

  (atom '())
  ;; t
  )
