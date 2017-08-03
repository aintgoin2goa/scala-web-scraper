.PHONY: test

sinclude .env
export $(shell [ -f .env ] && sed 's/=.*//' .env)

install:
	npm install

clean:
	sbt clean

test:
	sbt test

build:
	sbt assembly

deploy: build
	serverless deploy

run: build
	serverless offline start

info:
	serverless info

logs-%:
	serverless logs -f $*
