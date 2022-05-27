# jte-lib-custom-annotation

Demonstrates how a library developer could create a custom annotation and then query loaded libraries to find the annotated methods.

!!! warning

    If you stumble upon this, proceed with caution. I don't guarantee it will always work
    and it's not a "supported" JTE feature.

## How It Works

The `utility` library defines a new annotation [`@Container`](./utility/src/Container.groovy).

This class can be imported into other library steps because [JTE supports cross-library imports](https://jenkinsci.github.io/templating-engine-plugin/2.3/concepts/library-development/library-classes/).

The `someLibrary` example library creates a few steps and annotates several of them with the new annotation.

The `utility` library provides an `@Init` step called [`fetchContainers`](./utility/steps/fetchContainers.groovy) that aggregates the values of the annotations.