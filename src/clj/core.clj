(ns clj.core
  (:require [clojurecademy.dsl.core :refer :all]
            [clojurecademy.dsl.test :refer [defcoursetest]]))


(def my-manifest
  (manifest :title "Sample Course"
            :report-bug-email-or-link "https://github.com/clojurecademy/sample-course/issues"
            :name 'sample-course
            :skip? true
            :short-description "Sample Course Project for Clojurecademy DSL"
            :long-description "It's designed to teach \"How to make a course for Clojurecademy Platform?\"...."
            :who-is-this-course-for :no-programming-experience))


;;Chapters order matter(always) for all components as well
(def course-map
  (course my-manifest
          (chapter 'ch-intro
                   "Intro to Clojure"

                   (sub-chapter
                     'sub-ch-basics
                     "Basics"

                     (subject
                       'subj-about-clojure
                       "About Clojure"

                       (learn
                         (text
                           (p "Clojure is a functional programming that runs on JVM."))))

                     (subject
                       'subj-hello-world
                       "Hello, World"

                       (learn
                         (text
                           (p "Now we are going to use Clojure's print functionality to see some output.Please follow the instructions.")))
                       (instruction 'ins-clojure-helloworld
                                    (run-pre-tests? false)
                                    (initial-code :none)
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-ins-hello-world
                                                     (text
                                                       (p "Please print \"Hello, World\" to console "
                                                          "then click the Run button to see the result"))
                                                     (testing
                                                       (is (form-used? (println "Hello, World"))))))
                       'hello-world)

                     (subject
                       'subj-math-fns
                       "Let's write some math functions"

                       (learn
                         (text
                           (p "To understand Clojure comprehensively we are going to write some basic math functions in this section.")))
                       (instruction 'ins-subj-math-fns
                                    (run-pre-tests? false)
                                    (initial-code :none)
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-ins-my-add
                                                     (text
                                                       (p "Please write a function called "
                                                          (hi "my-add")
                                                          " which adds given numbers"))
                                                     (testing
                                                       (is (= (my-add 1) 1))
                                                       (is (= (my-add 1 2) 3))
                                                       (is (= (my-add 1 2 3 4 5 6) 21))))

                                    (sub-instruction 'sub-ins-my-subs
                                                     (text
                                                       (p "Please write a function called "
                                                          (hi "my-subs")
                                                          " which subtracts given numbers"))
                                                     (testing
                                                       (is (= (my-subs 1) -1))
                                                       (is (= (my-subs 2 1) 1))
                                                       (is (= (my-subs 100 1 2 3 4 5) 85)))))
                       'subj-math-fns)

                     (subject
                       'subj-more-math-fns-with-pre-tests-on
                       "Let's write some math functions"

                       (learn
                         (text
                           (p "To understand Clojure comprehensively we are going to write some basic math functions in this section.")))
                       (instruction 'ins-subj-math-fns
                                    (run-pre-tests? false)
                                    (initial-code :none)
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-ins-my-add
                                                     (text
                                                       (p "Please write a function called "
                                                          (hi "my-add")
                                                          " which adds given numbers"))
                                                     (testing
                                                       (is (= (my-add 1) 1))
                                                       (is (= (my-add 1 2) 3))
                                                       (is (= (my-add 1 2 3 4 5 6) 21))))

                                    (sub-instruction 'sub-ins-my-subs
                                                     (text
                                                       (p "Please write a function called "
                                                          (hi "my-subs")
                                                          " which subtracts given numbers"))
                                                     (testing
                                                       (is (= (my-subs 1) -1))
                                                       (is (= (my-subs 2 1) 1))
                                                       (is (= (my-subs 100 1 2 3 4 5) 85))))

                                    (sub-instruction 'sub-ins-my-multi
                                                     (text
                                                       (p "Please write a function called "
                                                          (hi "my-multi")
                                                          " which multiplies given numbers"))
                                                     (testing
                                                       (is (= (my-multi 1) 1))
                                                       (is (= (my-multi 2 1) 2))
                                                       (is (= (my-multi 1 2 3 4 5 6) 720)))))
                       'subj-math-fns)))))


(defcoursetest my-test-1
               [ch-intro sub-ch-basics subj-hello-world ins-clojure-helloworld sub-ins-hello-world]
               (println "Hello, World"))

(defcoursetest my-test-2
               [ch-intro sub-ch-basics subj-math-fns ins-subj-math-fns sub-ins-my-add]
               (defn my-add
                 [& args]
                 (apply + args)))

(defcoursetest my-test-3
               [ch-intro sub-ch-basics subj-math-fns ins-subj-math-fns sub-ins-my-subs]
               (defn my-subs
                 [& args]
                 (apply - args)))

(defcoursetest my-test-4
               [ch-intro sub-ch-basics subj-more-math-fns-with-pre-tests-on ins-subj-math-fns sub-ins-my-add]
               (defn my-add
                 [& args]
                 (apply + args)))

(defcoursetest my-test-5
               [ch-intro sub-ch-basics subj-more-math-fns-with-pre-tests-on ins-subj-math-fns sub-ins-my-subs]
               (defn my-add
                 [& args]
                 (apply + args))

               (defn my-subs
                 [& args]
                 (apply - args)))


(defcoursetest my-test-6
               [ch-intro sub-ch-basics subj-more-math-fns-with-pre-tests-on ins-subj-math-fns sub-ins-my-multi]
               (defn my-add
                 [& args]
                 (apply + args))

               (defn my-subs
                 [& args]
                 (apply - args))

               (defn my-multi
                 [& args]
                 (apply * args)))