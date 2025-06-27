compile:
	gradle spotlessApply
	gradle build
test:compile
	gradle spotlessApply
	gradle test