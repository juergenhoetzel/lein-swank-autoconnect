# lein-swan-autoconnect

## Intro 

While most other Lisp Swank Server implementations are started from
within Emacs, there is no single Clojure Swank Server you can start. 

Each Project uses a different Classpath and other customizations like JVM Options.

Although its possible to start a Leiningen based Swank Server using
[elein](https://github.com/remvee/elein), I prefer start the Swank
Server using the shell.

## Usage

autoconnect is implemented using "emacsclient" from within a Leiningen hook. 
So you must have Emacs running in Server Mode. 

### Emacs 
In your emacs config:

    (server-start)

### Leiningen project 

Add the lein-swank-autoconnect hook/dependency to your Leiningen project:

	(defproject foo "1.0.0-SNAPSHOT"
	  :description "FIXME: write"
	  :hooks [leiningen.hooks.swank-autoconnect]
	  :dependencies [[org.clojure/clojure "1.2.0"] [org.clojure/clojure-contrib "1.2.0"]]
	  :dev-dependencies [[lein-swank-autoconnect "1.0.0-SNAPSHOT"]
          		     [swank-clojure "1.2.1"]])
		     
