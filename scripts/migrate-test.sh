#!/usr/bin/env bash
set -e

HERE=$(dirname $0)
. $HERE/common
. $HERE/migrate-common.sh

docker run --rm -v ${PWD}/demo:/orderly $COMMIT_TAG