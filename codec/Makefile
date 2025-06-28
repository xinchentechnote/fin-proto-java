# Makefile for fin-protoc project

# Variables
.PHONY: all compile format fix clean

all: fmt test

fmt: fix
	@echo "Formatting code..."
	gradle spotlessApply


test:
	@echo "Running tests..."
	gradle test

# Help target
help:
	@echo "Available targets:"
	@echo "  all       - Run format and fix (default)"
	@echo "  fmt       - Format the code using cargo fmt"
	@echo "  help      - Show this help message"
