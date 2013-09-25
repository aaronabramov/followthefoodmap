(ns food.view.about
  (:require [clojure.java.io :as io]
            [compojure.core :refer [defroutes GET]]
            [food.view.common :refer [wrap-layout]]))

(defn- page-body [request]
  (slurp (io/resource "food/view/templates/about.html")))

(defn- render-page [request]
  (wrap-layout "About"
               (page-body request)))

(defroutes about-routes
  (GET "/about" request (render-page request)))

