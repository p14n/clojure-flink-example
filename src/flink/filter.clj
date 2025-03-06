(ns flink.filter
  (:import [java.io Serializable]
           [org.apache.flink.api.common.functions FilterFunction]))

(gen-class
 :name flink.filter.HttpFilter
 :implements [org.apache.flink.api.common.functions.FilterFunction
              java.io.Serializable]
 :prefix "http-"
 :methods [[filter [String] Boolean]])

(defn http-filter [this v]
  (.startsWith v "http://"))


(compile 'flink.filter)
