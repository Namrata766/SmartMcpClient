# 🏦 Smart MCP Client — Fraud Detection Console

A Spring Boot–based MCP (Model Context Protocol) client application designed for **commercial banking fraud analysis** using natural language inputs.

This application connects to an MCP server over **streamable HTTP (SSE)**, invokes fraud analysis tools, and presents results through a clean web UI.

---

## 🚀 Features

* 🔍 **Natural Language Fraud Analysis**

  * Submit queries like:

    > *"Analyze fraud risk for wire transactions on 2026-04-19"*

* 🔗 **MCP Client Integration**

  * Uses Spring AI MCP client with **streamable HTTP transport**
  * Supports tool invocation via MCP protocol

* 🔐 **API Key Authentication**

  * Secure communication with MCP server using `X-API-Key` header

* 📊 **Rich UI Rendering**

  * Markdown → HTML rendering
  * Mermaid diagram support for visual insights
  * Clean banking-style UI (Red / White / Yellow theme)

* ⚡ **Real-Time Streaming**

  * Uses SSE under the hood for live responses

---

## 🏗️ Architecture

```mermaid
graph TD
    UI[Web UI (Thymeleaf + JS)] -->|REST| Client[Spring Boot MCP Client]
    Client -->|HTTP SSE + API Key| MCP[MCP Server]
    MCP -->|Tool Execution| LLM[OpenAI / LLM]
    LLM --> MCP
    MCP --> Client
    Client --> UI
```

---

## 📦 Tech Stack

* **Java 23**
* **Spring Boot 4.x**
* **Spring AI (MCP Client)**
* **WebFlux (for streaming transport)**
* **Thymeleaf (UI)**
* **Mermaid.js (visual diagrams)**
* **Marked.js (Markdown rendering)**

---

## ⚙️ Configuration

### `application.yml`

```yaml
server:
  port: 8085

spring:
  application:
    name: SmartMcpClient

  ai:
    openai:
      api-key: ${OPEN_AI_API_KEY}
      chat:
        options:
          model: gpt-4o-mini

    mcp:
      client:
        type: sync
        streamable-http:
          connections:
            server1:
              url: http://localhost:8081
              endpoint: /mcp
```

---

## 🔐 API Key Setup (Client → Server)

The MCP server expects:

```http
X-API-Key: <your-api-key>
```

### Add header via WebClient customization

```java
@Bean
public WebClient.Builder webClientBuilder() {
    return WebClient.builder()
            .defaultHeader("X-API-Key", "your-api-key");
}
```

---

## 🧪 Running the Application

### 1. Start MCP Server

Ensure your MCP server is running on:

```
http://localhost:8081/mcp
```

---

### 2. Start Client

```bash
./gradlew bootRun
```

---

### 3. Open UI

```
http://localhost:8085
```

---

## 🖥️ Usage

1. Enter a natural language fraud query
2. Click **Analyze Fraud**
3. View structured results:

   * Portfolio summary
   * Transaction-level insights
   * Cross-transaction patterns

---

## 📄 Example Output

```markdown
### Fraud Risk Analysis

- Total Transactions: 3
- Overall Risk: HIGH

#### Key Insights
- Multiple off-hours transactions across accounts
- Repeated use of round-dollar amounts
- Watchlist-linked counterparties detected
```

---

## 🧠 Concepts

### Cross-Transaction Patterns

Identifies suspicious behavior **across multiple transactions**, such as:

* Off-hours activity across accounts
* Repeated structuring (round amounts)
* Behavioral consistency (same channel/timing)
* Account probing signals

---

## 📁 Project Structure

## 📁 Project Structure

```text
src/main/java/com/banking/mcp/
│
├── config/
│   ├── ChatClientConfig.java
│   └── McpWebClientConfig.java
│
├── controller/
│   └── FraudChatController.java
│
└── ui/
    └── UiController.java

---

## 🛠️ Future Enhancements

* 🔄 Streaming UI updates (live response rendering)
* 📊 Risk heatmaps & dashboards
* 🧾 PDF report export
* 🔑 Multi-key / DB-backed API key management
* 🧠 Enhanced fraud pattern detection (ML models)

---

## ⚠️ Disclaimer

This project is a **prototype / internal tool** for fraud analysis workflows.

* Not intended for production use without:

  * proper authentication (OAuth2 / mTLS)
  * audit logging
  * compliance validation

---

## 👩‍💻 Author

Built for exploring **Spring AI + MCP + Banking Fraud Detection** use cases.

---

## ⭐ Contributing

Feel free to fork, extend, and experiment with:

* new fraud patterns
* UI improvements
* advanced MCP integrations

---

## 📜 License

MIT License (or your preferred license)
