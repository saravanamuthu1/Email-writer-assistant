# Email Generator Assistant

The **Email Generator Assistant** is a service that generates email replies using the Gemini 1.5 AI model. The service takes an incoming email, along with the desired tone of the response, and generates an email reply. It uses the Gemini API to process the request and returns a natural, contextually aware response.

## Table of Contents

1. [Overview](#overview)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Configuration](#configuration)
5. [Usage](#usage)
6. [API Reference](#api-reference)
7. [Contributing](#contributing)
8. [License](#license)
9. [Contact](#contact)

---

## Overview

This project is a Spring Boot-based service that integrates with the **Gemini API** to generate email replies. It allows users to submit an email and receive a generated reply based on a specific tone. The service is designed to be easily extended or integrated into larger systems requiring automated email responses.

---

## Prerequisites

Before setting up the service, make sure you have the following:

- **Java 11 or later**: The project is built using Spring Boot, and Java 11 is the minimum required version.
- **Maven**: For building the project and handling dependencies.
- **Gemini API key**: You will need an API key for the Gemini 1.5 model.

---

## Installation

1. **Clone the repository**:

    ```bash
    git clone https://github.com/yourusername/email-generator.git
    cd email-generator
    ```

2. **Build the project**:

   If you don’t have Maven installed globally, you can run it through the Maven wrapper:

    ```bash
    ./mvnw clean install
    ```

   This will compile and build the application.

3. **Run the service**:

   Start the application with:

    ```bash
    ./mvnw spring-boot:run
    ```

   By default, the service will run on `http://localhost:8080`.

---

## Configuration

1. **Configure API URL and Key**:

   The `EmailGeneratorService` communicates with the Gemini API using the following properties:

    - `gemini.api.url`: The base URL for the Gemini API (e.g., `https://api.gemini.com`).
    - `gemini.api.key`: The API key for authenticating with the Gemini API.

   You can configure these properties by adding them to your `application.properties` file:

   ```properties
   gemini.api.url=https://api.gemini.com
   gemini.api.key=your-api-key-here
