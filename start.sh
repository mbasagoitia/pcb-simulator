#!/bin/bash
set -e

# Copy application.properties if it doesn't exist
if [ ! -f backend/src/main/resources/application.properties ]; then
    cp backend/src/main/resources/application.properties.example backend/src/main/resources/application.properties
    echo "Copied application.properties.example → application.properties"
fi

# Remove old Postgres container & volume if it exists
if docker ps -a --format '{{.Names}}' | grep -q '^app-postgres$'; then
    echo "Removing old Postgres container..."
    docker rm -f app-postgres
fi

if docker volume ls --format '{{.Name}}' | grep -q '^pcb-simulator_postgres_data$'; then
    echo "Removing old Postgres volume..."
    docker volume rm pcb-simulator_postgres_data
fi

# Start Postgres container
echo "Starting Postgres container..."
docker compose up -d db

# Wait for Postgres to be ready
echo "Waiting for Postgres to be ready..."
until docker compose exec db pg_isready -U postgres -d pcb_simulator > /dev/null 2>&1; do
    sleep 1
done
echo "Postgres is ready."

# Start backend
echo "Starting backend..."
(cd backend && mvn spring-boot:run) &

# Start frontend
echo "Starting frontend..."
(cd frontend && npm install && npm run dev) &

# Print URLs
echo "All services starting..."
echo "Backend: http://localhost:8080"
echo "Frontend: http://localhost:5173"
echo "Press Ctrl+C to stop everything"
