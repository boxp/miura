(ns leiningen.new.miura
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "miura"))

(defn miura
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' miura project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["Dockerfile" (render "Dockerfile" data)]
             ["now.json" (render "now.json" data)]
             ["package.json" (render "package.json" data)]
             ["workbox-config.js" (render "workbox-config.js" data)]
             ["README.md" (render "README.md" data)]
             ["resources/public/favicon.ico" (render "resources/public/favicon.ico" data)]
             ["resources/public/prod/img/clojure_logo.png" (render "resources/public/prod/img/clojure_logo.png" data)]
             ["resources/public/prod/favicon.ico" (render "resources/public/prod/favicon.ico" data)]
             ["resources/public/prod/manifest.json" (render "resources/public/prod/manifest.json" data)]
             ["src/cljs-client/{{name}}/client.cljs" (render "src/cljs-client/miura/client.cljs" data)]
             ["src/cljs-server/{{name}}/server.cljs" (render "src/cljs-server/miura/server.cljs" data)]
             ["src/cljs/{{name}}/coeffects.cljs" (render "src/cljs/miura/coeffects.cljs" data)]
             ["src/cljs/{{name}}/component.cljs" (render "src/cljs/miura/component.cljs" data)]
             ["src/cljs/{{name}}/config.cljs" (render "src/cljs/miura/config.cljs" data)]
             ["src/cljs/{{name}}/db.cljs" (render "src/cljs/miura/db.cljs" data)]
             ["src/cljs/{{name}}/effects.cljs" (render "src/cljs/miura/effects.cljs" data)]
             ["src/cljs/{{name}}/events.cljs" (render "src/cljs/miura/events.cljs" data)]
             ["src/cljs/{{name}}/route.cljs" (render "src/cljs/miura/route.cljs" data)]
             ["src/cljs/{{name}}/subs.cljs" (render "src/cljs/miura/subs.cljs" data)]
             ["src/cljs/{{name}}/util.cljs" (render "src/cljs/miura/util.cljs" data)]
             ["src/cljs/{{name}}/example/component.cljs" (render "src/cljs/miura/example/component.cljs" data)]
             ["src/cljs/{{name}}/example/container.cljs" (render "src/cljs/miura/example/container.cljs" data)])))
