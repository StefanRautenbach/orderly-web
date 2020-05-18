REGISTRY=docker.montagu.dide.ic.ac.uk:5000
REGISTRY_PUBLIC=vimc
NAME=orderlyweb-migrate

if [ -z "$TRAVIS_BRANCH" ]; then
    GIT_BRANCH=$(git symbolic-ref --short HEAD | sed 's;/;-;g')
    GIT_ID=$(git rev-parse --short=7 HEAD)
else
    GIT_BRANCH=$(sed 's;/;-;g' <<< $TRAVIS_BRANCH)
    GIT_ID=$TRAVIS_COMMIT
fi

TAG=$REGISTRY/$NAME
COMMIT_TAG=$REGISTRY/$NAME:$GIT_ID
BRANCH_TAG=$REGISTRY/$NAME:$GIT_BRANCH

COMMIT_TAG_PUBLIC=$REGISTRY_PUBLIC/$NAME:$GIT_ID
BRANCH_TAG_PUBLIC=$REGISTRY_PUBLIC/$NAME:$GIT_BRANCH
