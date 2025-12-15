#!/bin/bash

# 1. Copy application.properties if it doesn't exist
if [ ! -f backend/src/main/resources/application.properties ]; then
    cp backend/src/main/resources/application.properties.example backend/src/main/resources/application.properties
    echo "Copied application.properties.example → application.properties"
fi

# 2. Start Docker Postgres
echo "Starting Postgres container..."
docker compose up -d

# 3. Start Spring Boot backend in background
echo "Starting backend..."
(cd backend && mvn spring-boot:run) &

# 4. Start frontend
echo "Starting frontend..."
(cd frontend && npm install && npm run dev) &

echo "All services starting..."
echo "Backend: http://localhost:8080"
echo "Frontend: http://localhost:5173"
echo "Press Ctrl+C to stop everything"
