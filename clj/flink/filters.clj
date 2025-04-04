(ns flink.filters
  (:require [clojure.string :as str]))

(defn is-secure [s]
  (str/starts-with? s "https"))
