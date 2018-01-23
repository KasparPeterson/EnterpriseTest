#!/usr/bin/env bash

function test-app {
    ./gradlew app:testDebugUnitTest
}

function test-data {
    ./gradlew data:testDebugUnitTest
}

function test-domain {
    ./gradlew domain:test
}

function test-all {
    test-domain &&
    test-data &&
    test-app
}