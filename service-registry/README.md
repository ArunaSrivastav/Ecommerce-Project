# Service Discovery

A robust and scalable service discovery solution built with Java Spring Boot, designed to help microservices find and communicate with each other in distributed systems.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Documentation](#api-documentation)
- [Development](#development)
- [Testing](#testing)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Support](#support)

## 🔍 Overview

This service discovery application provides a centralized registry where microservices can register themselves and discover other services. It implements health checking, load balancing, and automatic service deregistration to ensure reliable service-to-service communication.

### Architecture

The service discovery system follows a client-server architecture where:
- Services register themselves with the discovery server
- Services query the registry to find other services
- Health checks ensure only healthy services are available
- Automatic cleanup removes stale service registrations

## ✨ Features

- **Service Registration**: Automatic service registration with metadata
- **Service Discovery**: Real-time service lookup and resolution
- **Health Monitoring**: Continuous health checking of registered services
- **Load Balancing**: Built-in load balancing strategies
- **High Availability**: Clustering support for fault tolerance
- **REST API**: RESTful endpoints for service management
- **Web Dashboard**: Administrative web interface
- **Metrics & Monitoring**: Built-in metrics and monitoring capabilities

## 📋 Prerequisites

Before running this application, ensure you have:

- **Java 21** or higher
- **Maven 3.8+** for dependency management
- **Git** for version control
- **Docker** (optional, for containerized deployment)

### System Requirements

- **Memory**: Minimum 512MB RAM (2GB recommended)
- **Storage**: At least 100MB free disk space
- **Network**: Open ports 8761 (default) and 8080 (management)

## 🚀 Installation

### Local Development Setup

1. **Clone the repository**
       ```bash
       git clone <repository-url>
       cd service-discovery
       ```

2. **Build the application**
       ```bash
       mvn clean compile
       ```

3. **Run tests**
       ```bash
       mvn test
       ```

4. **Start the application**
       ```bash
       mvn spring-boot:run
       ```

### Docker Setup

1. **Build Docker image**
       ```bash
       docker build -t service-discovery:latest .
       ```

2. **Run container**
       ```bash
       docker run -p 8761:8761 service-discovery:latest
       ```

## ⚙️ Configuration

### Application Properties

Configure the application using [application.properties](src/main/resources/application.properties) or environment variables:

    ```properties
    # Server Configuration
    server.port=8761
    spring.application.name=service-discovery
    
    # Service Discovery Configuration
    eureka.client.register-with-eureka=false
    eureka.client.fetch-registry=false
    eureka.server.enable-self-preservation=true
    
    # Health Check Configuration
    eureka.server.eviction-interval-timer-in-ms=15000
    eureka.instance.lease-renewal-interval-in-seconds=10
    ```

### Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `SERVER_PORT` | Application port | `8761` |
| `EUREKA_HOSTNAME` | Eureka server hostname | `localhost` |
| `MANAGEMENT_PORT` | Management endpoint port | `8080` |
| `LOG_LEVEL` | Logging level | `INFO` |

### Security Configuration

For production deployments, configure authentication:

    ```properties
    # Security Configuration
    spring.security.user.name=admin
    spring.security.user.password=${ADMIN_PASSWORD:changeme}
    spring.security.user.roles=ADMIN
    ```

## 📖 Usage

### Starting the Service

1. **Development Mode**
       ```bash
       mvn spring-boot:run -Dspring-boot.run.profiles=dev
       ```

2. **Production Mode**
       ```bash
       java -jar target/service-discovery-*.jar --spring.profiles.active=prod
       ```

### Accessing the Dashboard

Once started, access the Eureka dashboard at:
- **Local**: http://localhost:8761
- **Production**: http://your-domain:8761

### Service Registration Example

Services can register with the discovery server using:

    ```java
    @EnableEurekaClient
    @SpringBootApplication
    public class ClientApplication {
        public static void main(String[] args) {
            SpringApplication.run(ClientApplication.class, args);
        }
    }
    ```

## 🔌 API Documentation

### REST Endpoints

#### Service Registration
    ```http
    POST /eureka/apps/{appName}
    Content-Type: application/json
    
    {
      "instance": {
        "instanceId": "service-1",
        "hostName": "localhost",
        "app": "MY-SERVICE",
        "ipAddr": "192.168.1.100",
        "port": {"$": 8080, "@enabled": true}
      }
    }
    ```

#### Service Discovery
    ```http
    GET /eureka/apps
    Accept: application/json
    ```

#### Health Check
    ```http
    GET /actuator/health
    ```

### Response Formats

All API responses follow standard HTTP status codes:
- `200 OK`: Successful operation
- `404 Not Found`: Service not found
- `500 Internal Server Error`: Server error

## 🛠️ Development

### Project Structure
