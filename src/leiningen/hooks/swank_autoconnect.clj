(ns #^{:author "Jürgen Hötzel"
       :doc "autoconnect to emacs server using a Leiningen hook when starting swank"}
  leiningen.hooks.swank-autoconnect
  (:require  leiningen.compile leiningen.swank)
  (:use [robert.hooke :only [add-hook]])
  (:use [clojure.java.shell :only [sh]]))

(def default-port 4005)

;;; wait for server socket to apear
(def busy-wait-interval 500)

(defn swank-autoconnect-hook [task & args]
  (let [[_ port host] args]
    (if-not (zero? (:exit (sh "emacsclient" "-e" "emacs-version")))
      (println "WARNING: cannot connect using emacsclient (use 'M-x server-start')")
      (future
        (while (not (.startsWith (:out (sh "emacsclient" "-e" (format "(slime-connect \"localhost\" %s)" (or port default-port)))) "#<process"))
          (println "INFO: Connecting to slime server")
          (Thread/sleep busy-wait-interval)))))
  (apply task args))

(add-hook #'leiningen.swank/swank swank-autoconnect-hook)