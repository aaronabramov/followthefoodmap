(ns food.view.js-bundle
  (:require [compojure.core :refer [defroutes GET]]
            [clojure.java.shell :refer [sh]]))

(def app (slurp "./resources/coffee/app.coffee"))

(defn compiled-bundle []
  (:out (sh "coffee" "-s" "--compile" :in app)))

(defroutes js-routes
  (GET "/bundle.js" []
       {:status 200
        :headers {"Content-Type" "application/javascript"}
        :body (compiled-bundle)}))
