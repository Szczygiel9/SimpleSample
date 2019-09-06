#!/bin/sh -l

sh -c "docker pull mongo"
sh -c "docker run -d -p 27017-27019:27017-27019 --name mongodb mongo"