(ns day-1.core
  (:gen-class)
  (:require [clojure.string :as s]))

(defn fuel-equation
  [mass]
  (- (Math/floor (/ mass
                    3))
     2))

(defn fuel-double-checker
  [total mass]
  (loop [unit-fuel (fuel-equation mass)
         total-fuel 0]

    (if (<= unit-fuel 0)
      total-fuel
      (recur (fuel-equation unit-fuel)
             (+ total-fuel unit-fuel)))))

(defn fuel-counter-upper
  [filename]
  (let [input (slurp filename)
        numbers (map #(Integer/parseInt %) (s/split input #"\n"))
        mass (map fuel-double-checker numbers)]
        (reduce + mass)))



(defn -main
  [& args]
  (println "Hello, World!"))
