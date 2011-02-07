(defproject lein-swank-autoconnect "1.0.0"
  :description "Autoconnect to an Emacs server using a Leiningen hook when starting swank server"
  :url "https://github.com/juergenhoetzel/lein-swank-autoconnect"
  :hooks [leiningen.hooks.swank-autoconnect]
  :dependencies [[org.clojure/clojure "1.2.0"]]
  :dev-dependencies [[swank-clojure "1.2.1"]])
