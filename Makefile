GRADLE = gradle

.PHONY: all compile test clean check install help

all: compile test

compile:
	$(GRADLE) spotlessApply
	$(GRADLE) build

test: compile
	$(GRADLE) test

clean:
	$(GRADLE) clean

check:
	$(GRADLE) check

install: compile
	$(GRADLE) publishToMavenLocal

help:
	@echo "Available targets:"
	@echo "  all      - Compile and run tests (default)"
	@echo "  compile  - Apply code formatting and build the project"
	@echo "  test     - Run tests (depends on compile)"
	@echo "  clean    - Clean build artifacts"
	@echo "  check    - Run checks (linting, etc.)"
	@echo "  install  - Publish to local Maven repository (depends on compile)"
