(ns food.view.js-bundle
  (:require [compojure.core :refer [defroutes GET]]
            [clojure.java.shell :refer [sh]]))

(defn compiled-bundle []
  "Compiled browserify bundle"
  (:out (sh "coffee" "./scripts/bundle.coffee")))

(defroutes js-routes
  (GET "/bundle.js" []
       {:status 200
        :headers {"Content-Type" "application/javascript"}
        :body (compiled-bundle)}))
