
Example of using web-workers in ScalaJS.

Based off of [https://github.com/sjrd/scala-js-actors/tree/master/examples/webworkers](https://github.com/sjrd/scala-js-actors/tree/master/examples/webworkers), but without any of the additional architecture for actors.

# Running

In SBT, run

    > ~fake-site/site

This will generate a complete runnable site in `fake-site/target/site`

To run it from the local filesystem in most browsers you will need to override some same-origin security policies; for example in Chrome you can use [`--disable-web-security`](http://stackoverflow.com/a/3177718/371739).

In the browser, open up a web console to view the output. 
