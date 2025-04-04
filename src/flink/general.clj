(ns flink.general)

(gen-class
 :name flink.general.CljFilter
 :implements [org.apache.flink.api.common.functions.FilterFunction
              java.io.Serializable]
 :prefix "clj-"
 :state        state
 :methods [[filter [String] Boolean]]
 :init         init
 :constructors {[String String] []})

(defn load-fn [ns-name fn-name]
  (let [fn-sym (symbol (str ns-name) (str fn-name))
        resolved-fn (requiring-resolve fn-sym)]
    resolved-fn))

(defn clj-init
  [ns-name f-name]
  [[] (load-fn ns-name f-name)])

(defn clj-filter [this v]
  (println this v)
  ((.state this) v))