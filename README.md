# Product AI Catalog API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)
![Build](https://img.shields.io/badge/build-Maven-red)

Backend REST API built with **Spring Boot** that combines a traditional **CRUD product catalog** with **AI-powered product analysis**.

The application allows storing products in a database and using **AI to generate descriptions and analyze products automatically**.

---

## Architecture

The project follows a layered architecture:

### Controller → Service → Repository → Database

AI features are separated in an independent module:

### AI Controller → AI Service → Prompt Engine → LLM
---
## Features

- Product CRUD (Create, Read, Update, Delete)
- AI-generated product descriptions
- AI product analysis
- Estimated price generation
- Product category detection
- Price evaluation
- RESTful API design
- DTO-based architecture
- Prompt engineering with Spring AI

---

## Tech Stack

- **Java 21**
- **Spring Boot**
- **Spring AI**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

---

## Architecture

### The project follows a layered architecture:
````
controller
↓
service
↓
repository
↓
database

ai
↓
prompt
↓
service
````


### Main Components

**Product**
- Entity stored in the database
- Basic product catalog information

**AI Module**
- Generates product descriptions
- Analyzes products using LLM prompts
- Returns structured JSON responses

---

## Product Entity

Example product stored in the database:

````

{
  "id": 1,
  "name": "Nike Air Force 1",
  "description": "Classic basketball sneakers with durable leather construction and Air-Sole cushioning",
  "price": 120
}
````

## API Endpoints
### Product CRUD
Method|	Endpoint|	Description|
------|---------|------------|
POST|	/products|	Create product|
GET|	/products|	Get all products|
GET|	/products/{id}|	Get product by id|
PUT	|/products/{id}	|Update product|
DELETE|	/products/{id}|	Delete product|
---

## AI Endpoints
### Generate Product Description
````
POST /ai/generate-description
````
### Request:
````
{
  "name": "Nike Air Force 1"
}
````

### Response:
````
{
  "description": "Classic basketball sneakers with durable leather construction and Air-Sole cushioning, designed for comfort and everyday wear.",
  "price": 120
}
````
### Analyze Product
````
POST /ai/analyze-product
````
### Request:
````
{
  "name": "Nike Air Force 1"
}
````
### Response:
````
{
  "name": "Nike Air Force 1",
  "description": "Classic basketball sneakers featuring durable leather construction and Air-Sole cushioning for comfort and performance.",
  "price": 120,
  "priceEvaluation": "normal",
  "category": "footwear"
}
````
## AI Integration

### The AI features are implemented using Spring AI.

### The application uses structured prompts to:

- Generate realistic product descriptions

- Estimate market prices

- Categorize products

- Provide price evaluation

### AI responses are mapped directly to DTOs to ensure structured JSON output.

## Project Structure
````
src/main/java/com/david/productAI

ai
prompt
service

config

controller

dto

exception

mapper

model

repository

service
````
## Running the Application
### 1 Clone the repository
````
git clone https://github.com/your-username/product-ai-catalog-api.git
````
### 2 Configure environment variables

Configure your AI provider key in application.properties or environment variables.

Example:
````
OPENAI_API_KEY=your_key
````
### 3 Run the project
````
mvn spring-boot:run
````
The API will start on:
````
http://localhost:8080
````
## Future Improvements

- Possible improvements for the project:

- Product comparison with AI

- Alternative product suggestions

- AI analysis caching

- Frontend integration

- Cloud deployment

## Purpose of the Project

### This project was built as a backend portfolio project to explore:

- AI integration in Spring Boot

- Prompt engineering

- REST API design

- Modern backend architecture

## Author

### David Ferrer
### Backend Developer (Java / Spring Boot)
