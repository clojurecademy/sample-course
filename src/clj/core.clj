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
                                    (run-pre-tests? true)
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
                       'subj-math-fns)

                     (subject
                       'subj-initial-code-ex-1
                       "Let's see some initial code"

                       (learn
                         (text
                           (p "Check code in the editor")))
                       (instruction 'ins-initial-code-ex-1
                                    (run-pre-tests? false)
                                    (initial-code (println "Hello, World"))
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-initial-code-ex-1
                                                     (text
                                                       (p "Please click the Run button"))
                                                     (testing
                                                       ;;mock true for demo
                                                       (is (true? true)))))
                       'initial-code-ex-1)

                     (subject
                       'subj-initial-code-ex-2
                       "Let's see some initial code 2"

                       (learn
                         (text
                           (p "Check code in the editor")))
                       (instruction 'ins-initial-code-ex-2
                                    (run-pre-tests? false)
                                    (initial-code "\n\n(defn your-fn\n  [x y]\n  )")
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-initial-code-ex-2
                                                     (text
                                                       (p "Please click the Run button"))
                                                     (testing
                                                       ;;mock true for demo
                                                       (is (true? true)))))
                       'initial-code-ex-2)

                     (subject
                       'subj-initial-code-ex-3
                       "Let's see some initial code 3"

                       (learn
                         (text
                           (p "Check code in the editor")))
                       (instruction 'ins-initial-code-ex-3
                                    (run-pre-tests? false)
                                    (initial-code (str "\n\n(println \"Scalars: \\n\")\n\n\n"
                                                       "(println \"Type of 1 is: \" (type 1) \"\\n\")\n\n\n"
                                                       "(println \"Type of 1.2 is: \" (type 1.2) \"\\n\")\n\n\n"
                                                       "(println \"Type of 1N is: \" (type 1N) \"\\n\")\n\n\n"
                                                       "(println \"Type of 1.5M is: \" (type 1.5M) \"\\n\")\n\n\n"
                                                       "(println \"Type of 1.2e4 is: \" (type 1.2e4) \"\\n\")\n\n\n"
                                                       "(println \"Type of 1/3 is: \" (type 1/3) \"\\n\")\n\n\n"
                                                       "(println \"Type of \\\"HEY!\\\" is: \" (type \"HEY!\") \"\\n\")\n\n\n"
                                                       "(println \"Type of \\\\a is: \" (type \\a) \"\\n\")\n\n\n"
                                                       "(println \"Type of :my-keyword is: \" (type :my-keyword) \"\\n\")\n\n\n"
                                                       "(println \"Type of 'my-s is: \" (type 'my-s) \"\\n\")"))
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-initial-code-ex-3
                                                     (text
                                                       (p "Please click the Run button"))
                                                     (testing
                                                       ;;mock true for demo
                                                       (is (true? true)))))
                       'initial-code-ex-3)

                     (subject
                       'subj-initial-code-ns-ex
                       "Let's see some initial code"

                       (learn
                         (text
                           (p "Check code in the editor")))
                       (instruction 'ins
                                    (run-pre-tests? false)
                                    (initial-code "\n(ns clj.core\n  (:require [clojure.string :as str]))\n\n(defn your-fn\n  []\n  )")
                                    (rule :no-rule? true)

                                    (sub-instruction 'sub-ins
                                                     (text
                                                       (p "Please click the Run button"))
                                                     (testing
                                                       ;;mock true for demo
                                                       (is (true? true))))))

                     (subject 'subj-rule-restricted-ex
                              "Last Element"

                              (learn
                                (text
                                  (p "Write a function called " (hi "my-last") " which returns the last element in a sequence.")))

                              (instruction 'ins-rule-restricted-ex
                                           (run-pre-tests? false)
                                           (initial-code :none)
                                           (rule :restricted-fns '[last])

                                           (sub-instruction 'sub-ins-rule-restricted-ex
                                                            (text
                                                              (p "Tests need to pass:")
                                                              (code (= (my-last [1 2 3 4 5]) 5))
                                                              (code "(= (my-last '(5 4 3)) 3)")
                                                              (code (= (my-last ["b" "c" "d"]) "d")))
                                                            (testing
                                                              (is (= (my-last [1 2 3 4 5]) 5) nil :advanced)
                                                              (is (= (my-last '(5 4 3)) 3) nil :advanced)
                                                              (is (= (my-last ["b" "c" "d"]) "d") nil :advanced))))
                              'rule-restricted-ex)

                     (subject 'subj-rule-only-one-fn-ex
                              "Last Element"

                              (learn
                                (text
                                  (p "Write a function called " (hi "my-last") " which returns the last element in a sequence.")))

                              (instruction 'ins-rule-only-one-fn-ex
                                           (run-pre-tests? false)
                                           (initial-code :none)
                                           (rule :only-use-one-fn? true)

                                           (sub-instruction 'sub-ins-rule-only-one-fn-ex
                                                            (text
                                                              (p "Tests need to pass:")
                                                              (code (= (my-last [1 2 3 4 5]) 5))
                                                              (code "(= (my-last '(5 4 3)) 3)")
                                                              (code (= (my-last ["b" "c" "d"]) "d")))
                                                            (testing
                                                              (is (= (my-last [1 2 3 4 5]) 5) nil :advanced)
                                                              (is (= (my-last '(5 4 3)) 3) nil :advanced)
                                                              (is (= (my-last ["b" "c" "d"]) "d") nil :advanced))))
                              'rule-only-one-fn-ex)

                     (subject 'subj-rule-required-fn-ex
                              "Last Element"

                              (learn
                                (text
                                  (p "Write a function called " (hi "my-last") " which returns the last element in a sequence.")))

                              (instruction 'ins-rule-required-fn-ex
                                           (run-pre-tests? false)
                                           (initial-code :none)
                                           (rule :required-fns '[last]
                                                 :only-use-one-fn? true)

                                           (sub-instruction 'sub-ins-rule-required-fn-ex
                                                            (text
                                                              (p "Tests need to pass:")
                                                              (code (= (my-last [1 2 3 4 5]) 5))
                                                              (code "(= (my-last '(5 4 3)) 3)")
                                                              (code (= (my-last ["b" "c" "d"]) "d")))
                                                            (testing
                                                              (is (= (my-last [1 2 3 4 5]) 5) nil :advanced)
                                                              (is (= (my-last '(5 4 3)) 3) nil :advanced)
                                                              (is (= (my-last ["b" "c" "d"]) "d") nil :advanced))))
                              'rule-required-fn-ex)))))


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

(defcoursetest my-test-7
               [ch-intro sub-ch-basics subj-initial-code-ex-1 ins-initial-code-ex-1 sub-initial-code-ex-1]
               ;;empty vec is for mocking(defcoursetest body can't be empty), it has no effect
               [])

(defcoursetest my-test-8
               [ch-intro sub-ch-basics subj-initial-code-ex-2 ins-initial-code-ex-2 sub-initial-code-ex-2]
               [])

(defcoursetest my-test-9
               [ch-intro sub-ch-basics subj-initial-code-ex-3 ins-initial-code-ex-3 sub-initial-code-ex-3]
               [])

(defcoursetest my-test-10
               [ch-intro sub-ch-basics subj-initial-code-ns-ex ins sub-ins]
               [])

(defcoursetest my-test-11
               [ch-intro sub-ch-basics subj-rule-restricted-ex ins-rule-restricted-ex sub-ins-rule-restricted-ex]
               (defn my-last
                 [x]
                 ;if you comment out last fn you will get an exception for :restricted-fns
                 ;(last x)
                 (nth x (- (count x) 1))))

(defcoursetest my-test-12
               [ch-intro sub-ch-basics subj-rule-only-one-fn-ex ins-rule-only-one-fn-ex sub-ins-rule-only-one-fn-ex]
               ;if you comment out my-fn you will get an exception for :only-use-one-fn?
               ;(defn my-fn
               ;  [])
               (defn my-last
                 [x]
                 (nth x (- (count x) 1))))

(defcoursetest my-test-13
               [ch-intro sub-ch-basics subj-rule-required-fn-ex ins-rule-required-fn-ex sub-ins-rule-required-fn-ex]
               ;if you comment out my-fn you will get an exception for :required-fns and :only-use-one-fn?
               ;(defn my-fn
               ;  [])
               (defn my-last
                 [x]
                 ;;if you don't use last you will get an exception
                 (last x)))


