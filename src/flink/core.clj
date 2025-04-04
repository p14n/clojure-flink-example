(ns flink.core
  (:import
   [flink.general CljFilter]
   [org.apache.flink.api.java ExecutionEnvironment]))

(def env (ExecutionEnvironment/getExecutionEnvironment))

(def data (.readTextFile env "./test.txt"))

(def filtered (.filter data (CljFilter. "flink.filters" "is-secure")))

(.writeAsText filtered "./result")

(.execute env)
