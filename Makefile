.PHONY: test

# Export environment variables if a .env file is present.
ifeq ($(ENV_EXPORTED),) # ENV vars not yet exported
ifneq ("$(wildcard .env)","")
sinclude .env
export $(shell [ -f .env ] && sed 's/=.*//' .env)
export ENV_EXPORTED=true
$(info Note — An .env file exists. Its contents have been exported as environment variables.)
endif
endif

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
