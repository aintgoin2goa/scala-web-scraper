.PHONY: test

sinclude .env

test:
	sbt test

build:
	sbt assembly

deploy:
	serverless deploy