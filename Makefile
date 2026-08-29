.PHONY: all install build run test clean docker-build docker-up docker-down

all: install build test

install:
	@echo "Installing frontend dependencies..."
	cd frontend && npm install
	@echo "Installing mobile dependencies..."
	cd mobile && npm install

build:
	@echo "Building frontend..."
	cd frontend && npm run build
	@echo "Building backend..."
	cd backend && mvn clean package -DskipTests

run:
	@echo "Starting full-stack development environment..."
	cd frontend && npm run dev

test:
	@echo "Running backend unit and integration tests..."
	cd backend && mvn test
	@echo "Running frontend E2E workflow tests..."
	cd frontend && npm test

clean:
	@echo "Cleaning build artifacts..."
	rm -rf frontend/dist mobile/dist backend/target

docker-build:
	docker build -t hospital-management-system:latest .

docker-up:
	docker compose up --build -d

docker-down:
	docker compose down
