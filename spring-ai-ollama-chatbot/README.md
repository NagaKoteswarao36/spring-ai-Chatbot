# Spring AI Ollama Chatbot — Java 17

A minimal Spring Boot REST API using Spring AI `ChatClient` and a local Ollama model.

## Requirements
- JDK 17
- IntelliJ IDEA
- Ollama installed: https://ollama.com

## Start Ollama
In a terminal, download a model and ensure Ollama is running:

```bash
ollama pull llama3.2
ollama serve
```

If Ollama is already running as a service, you may not need to run `ollama serve`. Check the installed models with `ollama list`. The model name must match `spring.ai.ollama.chat.options.model` in `application.properties`.

## Open in IntelliJ IDEA
1. Extract the ZIP.
2. Select **File → Open** and choose the `spring-ai-ollama-chatbot` folder.
3. Set Project SDK to **JDK 17** in **File → Project Structure → Project**.
4. Allow Maven to import the project and download dependencies.
5. Run `ChatbotApplication.java`.

## Test the API

Health check:

```bash
curl http://localhost:8080/api/chat/health
```

Chat request:

```bash
curl -X POST http://localhost:8080/api/chat -H "Content-Type: application/json" -d "{\"message\":\"Explain dependency injection in Spring Boot.\"}"
```

Or use Postman:
- Method: `POST`
- URL: `http://localhost:8080/api/chat`
- Header: `Content-Type: application/json`
- Body → raw → JSON:

```json
{
  "message": "What is Spring AI?"
}
```

Expected response shape:

```json
{
  "answer": "The model-generated answer appears here."
}
```

## Request flow

```text
Postman → ChatController → ChatService → Spring AI ChatClient
        → Ollama API (localhost:11434) → Local model → ChatResponse
```

## Troubleshooting
- **Connection refused on port 11434:** start Ollama and verify it is running.
- **Model not found:** run `ollama pull llama3.2` or update the configured model name.
- **Maven dependency errors:** reload Maven and check internet/proxy settings.
- **Slow first response:** the local model may need time to load; speed depends on model size and hardware.
- **Java version error:** set both IntelliJ Project SDK and Maven runner to JDK 17.

This is a learning starter. Before production, add authentication, rate limits, request limits, structured error handling, timeouts, observability, and privacy controls.
