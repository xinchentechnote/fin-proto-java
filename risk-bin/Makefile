# Makefile for fin-protoc project

# Variables
PROTO_DSL := ../submodules/fin-proto/risk/risk_v0.1.0.dsl
PROTO_DIR := proto/
OUTPUT_DIR := src/
BIN_DIR := ~/workspace/fin-protoc/bin/

.PHONY: all compile format fix clean

all: compile fmt test

build: compile

set_env:
	export PATH=$(BIN_DIR):$$PATH

compile:
	@echo "Compiling protocol..."
	$(BIN_DIR)/fin-protoc -f $(PROTO_DSL) -j $(OUTPUT_DIR)

fmt: fix
	@echo "Formatting code..."
	gradle spotlessApply


test:
	@echo "Running tests..."
	gradle test

# Help target
help:
	@echo "Available targets:"
	@echo "  all       - Run compile, format and fix (default)"
	@echo "  compile   - Compile the protocol definitions"
	@echo "  build   - Compile the protocol definitions"
	@echo "  fmt       - Format the code using cargo fmt"
	@echo "  help      - Show this help message"
