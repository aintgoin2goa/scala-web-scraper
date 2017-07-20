.PHONY: test

sinclude .env

clean:
	sbt clean

test:
	sbt test

build:
	sbt assembly

deploy:
	serverless deploy