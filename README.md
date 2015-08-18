# clj-bob

A Clojure (technically) port of [J-Bob](https://github.com/the-little-prover/j-bob), the proof assistant from [The Little Prover](https://mitpress.mit.edu/books/little-prover) by Daniel P. Friedman and Carl Eastlund.

## caveats

Ok, so first of all, this is not normal Clojure.
Like the Scheme implementation, this is mostly macros and functions that operate on/emulate ACL2 syntax.
On the one hand, that's really weird.
On the other, that means that this matches the book exactly in almost all cases -- a worthy trade.
I've successfully tested a bunch of the book's examples (including the final one) and they've all matched the Scheme implementation, but that's the best I can give you right now in terms of assurances.

## weird stuff

The book/J-Bob assume that `.` and `/` are legal to use in function names.
Unfortunately, Clojure disagrees.
Through the use of advanced search-and-replace™ technology, I changed all `.`s and `/`s into `-`.
That means that `chapter1.example1` is now `chapter1-example1`, `dethm.set?/sub` is now `dethm-set?-sub`, etc.

## usage

Assuming you have [Leiningen](http://leiningen.org) installed, just clone this repository and run `lein repl` inside of it.
Everything's pre-configured, so you can immediately start typing examples from the book and you *should* see exactly the same output.

For example:

```clojure
#_clj-bob.j-bob=> (car (cons 'ham '(eggs)))
ham
#_clj-bob.j-bob=> (atom '()) ;; no, this is not Clojure
t
```
