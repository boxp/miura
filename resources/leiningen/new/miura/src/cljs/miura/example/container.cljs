(ns {{name}}.example.container
  (:require [reagent.core :as reagent]
            [{{name}}.example.component :as component]
            [{{name}}.util :as util]
            [re-frame.core :as re-frame]))

(defn box
  [params]
  [component/box params])

(util/universal-set-loaded! :example)
