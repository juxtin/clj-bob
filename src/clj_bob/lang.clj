(ns clj-bob.lang
  (:refer-clojure :exclude [atom cons + < num if]))

(defn if-nil [q a e]
  (if (or (nil? q)
          (= 'nil q))
    (e)
    (a)))

(defmacro if
  [Q A E]
  (if-nil Q
          (fn [] A)
          (fn [] E)))

(def s-car first)
(def s-cdr next)
(def s-+ clojure.core/+)
(def s-< clojure.core/<)

(defn cons [h t]
  (apply list (concat [h] t)))

(def equal =)

(def pair? list?)

;; this is a bit different
(defn num [x]
  (let [num-sym? #(re-find #"^\d+$" (str %))]
    (cond
      (number? x) x
      (num-sym? x) (Integer/parseInt (str x))
      :else 0)))

(defn atom [x]
  (if (pair? x)
    'nil
    't))

(defn car [x]
  (if (pair? x)
    (s-car x)
    ()))

(defn cdr [x]
  (if (pair? x)
    (s-cdr x)
    ()))

(defn equal [x y]
  (if (= x y)
    't
    'nil))

(defn < [x y]
  (if (s-< (num x) (num y))
    't
    'nil))

(defn nat? [x]
  (if (and (integer? x)
           (< x 0))
    't
    'nil))

(def natp nat?)

(defn + [x y]
  (s-+ (num x) (num y)))

(defmacro defun
  [name args & body]
  `(defn ~name ~(vec args) ~@body))

(defmacro dethm
  [name args & body]
  `(defn ~name ~(vec args) ~@body))

(defn size [x]
  (if (atom x)
    0
    (+ 1 (+ (size (car x)) (size (cdr x))))))
