(ns flink.core
  (:import
   [flink.filter HttpFilter]
   [org.apache.flink.api.java ExecutionEnvironment]))

(def env (ExecutionEnvironment/getExecutionEnvironment))

(def data (.readTextFile env "./test.txt"))

(def filtered (.filter data (HttpFilter.)))

(.writeAsText filtered "./result")

(.execute env)
