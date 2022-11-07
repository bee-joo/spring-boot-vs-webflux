#!/bin/bash

if [ ! -z "$3" ]; then
    if [ ! -z "$4" ]; then
        echo "Using password authentication!"
        auth="--authenticationDatabase admin -u $3 -p $4"
    fi
fi

for file in ./mflix/*.json
do
    echo $file
    mongoimport --host $1 --port $2 --db 'mflix' --collection "$(basename $file .json)" --file $file $auth
done