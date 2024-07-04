document.addEventListener("DOMContentLoaded", () => {
    const eventForm = document.getElementById("event-form");
    const userForm = document.getElementById("user-form");
    const listEventsBtn = document.getElementById("list-events-btn");
    const eventsList = document.getElementById("events-list");

    if (eventForm) {
        eventForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const eventName = document.getElementById("event-name").value;
            const eventDescription = document.getElementById("event-description").value;
            const eventDate = document.getElementById("event-date").value;
            const eventTime = document.getElementById("event-time").value;
            const eventCategory = document.getElementById("event-category").value;
            const eventVacancies = document.getElementById("event-vacancies").value;

            fetch("/api/events", {  
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    nome: eventName,
                    descricao: eventDescription,
                    data: eventDate,
                    horario: eventTime,
                    categoria: eventCategory,
                    vagas: eventVacancies
                })
            }).then(response => {
                if (response.ok) {
                    alert("Event added successfully!");
                    eventForm.reset();
                } else {
                    response.json().then(data => alert("Failed to add event: " + data.message));
                }
            }).catch(error => {
                console.error('Error:', error);
                alert("Failed to add event due to network error.");
            });
        });
    }

    if (userForm) {
        userForm.addEventListener("submit", (e) => {
            e.preventDefault();
            const userName = document.getElementById("user-name").value;
            const userEmail = document.getElementById("user-email").value;

            // Call your backend API to register the user
            fetch("/api/users", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    name: userName,
                    email: userEmail
                })
            }).then(response => {
                if (response.ok) {
                    alert("User registered successfully!");
                    userForm.reset();
                } else {
                    response.json().then(data => alert("Failed to register user: " + data.message));
                }
            }).catch(error => {
                console.error('Error:', error);
                alert("Failed to register user due to network error.");
            });
        });
    }

    if (listEventsBtn) {
        listEventsBtn.addEventListener("click", () => {
            // Call your backend API to list events
            fetch("/api/events")
                .then(response => response.json())
                .then(events => {
                    eventsList.innerHTML = "";
                    events.forEach(event => {
                        const li = document.createElement("li");
                        li.textContent = `${event.nome} - ${event.data} - ${event.categoria}`;
                        eventsList.appendChild(li);
                    });
                }).catch(error => {
                    console.error('Error:', error);
                    alert("Failed to load events due to network error.");
                });
        });
    }
});
