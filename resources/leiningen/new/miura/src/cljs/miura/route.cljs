(ns {{name}}.route
  (:require
    [re-frame.core :as re-frame]
    [{{name}}.util :as util]
    [{{name}}.events :as events]
    [secretary.core :as secretary :refer-macros [defroute]]))

;; prefixなし
(secretary/set-config! :prefix "/")

(def route-table
  {:example {:title "Example"
             :container #(resolve '{{name}}.example.container/box)
             :module-name :example}})

(defn- lazy-push
  [key params]
  (util/universal-load (-> route-table key :module-name) #(re-frame/dispatch-sync [::events/push key params])))

;; ルーティング定義
(defroute root-path "/" []
  (lazy-push :example {}))

(defroute not-found-path "*" []
  (lazy-push :example {}))
