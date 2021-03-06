(ns {{name}}.events
  (:require
   [re-frame.core :as re-frame]
   [{{name}}.effects :as effects]
   [{{name}}.coeffects :as coeffects]
   [{{name}}.db :as db]))

(re-frame/reg-event-fx
 ::initialize
 (fn [{:keys []} [_ history preload]]
   (as-> {:db db/default-db} $
     (if preload (update $ :db #(merge % preload)))
     (if history (assoc-in $ [:db :history] history) $))))

(re-frame/reg-event-db
 ::push
 (fn [db [_ key params]]
   (-> db
       (assoc-in [:router :key] key)
       (assoc-in [:router :params] params))))

(re-frame/reg-event-fx
 ::api-error
 (fn [{:keys [db]} [_ error]]
   {:db (assoc db :api-error error)}))
