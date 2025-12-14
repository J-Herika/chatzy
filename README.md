Chatzy API 💬

A Simple Real-Time Messaging Backend

This is my second Spring Boot project, built to understand how backends handle real-time communication. It focuses on 1-on-1 messaging using WebSockets and persistent chat history.
🛠️ Tech Stack

    Java & Spring Boot

    Spring Data JPA (for Database interactions)

    WebSocket (STOMP protocol)

    H2 Database (for testing)

🚀 Features

    User Management: Simple user creation and retrieval.

    Real-Time Messaging: Instant message delivery using WebSockets without refreshing the page.

    Chat History: Rest API to load previous messages between two users.

    Data Persistence: Messages are saved to the database automatically.

📝 Developer's Journey

This project was a significant learning curve compared to my first one. It taught me important lessons about scoping and system complexity.

💡 Challenges & Learnings

    Spring & JPA: Moving from raw SQL to Spring’s annotations (@) and "magic" JpaRepository methods was confusing at first, but I eventually realized how much development time they save.

    REST vs. WebSockets: The biggest hurdle was shifting from standard REST APIs to WebSockets. Grasping persistent connections and message brokers was difficult, but getting real-time updates working was a major milestone.

    The Importance of Scoping: I initially over-scoped with Group Chats but realized the database complexity was too high. Scaling back to 1-on-1 taught me the value of building a solid, working feature over a complex, broken one.

    Logic & Architecture: I gained valuable experience in structuring a backend properly—specifically using Services, DTOs for clean data.

🏃‍♂️ How to Run

    Clone the repo.

    Run ChatzyApplication.java.

    Use Postman or the included HTML tester file to connect to ws://localhost:8080/ws.
