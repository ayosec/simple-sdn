## Download and install

You need Java 7

    $ export GRAPHENEDB_URL="https://$user:$token@hostname:1234"
    $ curl -L https://github.com/ayosec/simple-sdn/releases/download/v0.1/simple-sdn-0.1.tar.bz2 | tar xj

The command is launched with `bin/main`. Possible options are

* `bin/main node 1` show properties of node 1
* `bin/main query 'match (n) return n limit 5'` executes the Cypher query.

Examples:

    $ bin/main node 7
    Node#7 props[abc=100]

    $ bin/main query 'match (n) return count(n)'
    [Query] match (n) return count(n)
    {count(n)=8}

## Compile from sources

Install [SBT](http://www.scala-sbt.org/download.html) and type

    $ sbt pack

In the `target/pack` directory you will find the generated packages to launch the application.
