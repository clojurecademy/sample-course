(defproject sample-project "0.1.0-SNAPSHOT"

  :description "FIXME: write description"

  :url "http://example.com/FIXME"

  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clojurecademy/dsl "0.3.5"]]

  :eval-in :leiningen

  :plugins [[clojurecademy/lein-clojurecademy "0.1.2"]]

  :clojurecademy {:course-map clj.core/course-map
                  :helper-fns-ns clj.helper-fns})