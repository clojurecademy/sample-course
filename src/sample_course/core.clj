(ns sample-course.core
  (:require [clojurecademy.dsl.core :refer :all]))


(def my-manifest (manifest :title "4Clojure 7"
                           ;;TODO provide github link
                           :report-bug-email-or-link "ertu@gmail.com"
                           :name 'for-clojure-7
                           :skip? true
                           :short-description "4Clojure problems with few differences"
                           :long-description "4Clojure(4clojure.com) is a resource to help fledgling Clojurians learn the language through interactive problems.
                        The first few problems are easy enough that even someone with no prior experience should find the learning curve forgiving.
                        Also, in this course content of http://clojure-doc.org has been used for teaching Clojure basics."
                           :who-is-this-course-for :programming-experience))


;;Chapters order matter
(def course-map (course my-manifest
                        intro-to-clojure
                        problems))