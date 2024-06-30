document.addEventListener("DOMContentLoaded", () => {
    const eventForm = document.getElementById("event-form");
    const userForm = document.getElementById("user-form");
    const listEventsBtn = document.getElementById("list-events-btn");
    const eventsList = document.getElementById("events-list");

    eventForm.addEventListener("submit", (e) => {
        e.preventDefault();
        const eventName = document.getElementById("event-name").value;
        const eventDate = document.getElementById("event-date").value;
        const eventType = document.getElementById("event-type").value;

        // Call your backend API to add the event
        // Example using fetch
        fetch("/api/events", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: eventName,
                date: eventDate,
                type: eventType
            })
        }).then(response => {
            if (response.ok) {
                alert("Event added successfully!");
                eventForm.reset();
            } else {
                alert("Failed to add event.");
            }
        });
    });

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
                alert("Failed to register user.");
            }
        });
    });

    listEventsBtn.addEventListener("click", () => {
        // Call your backend API to list events
        fetch("/api/events")
            .then(response => response.json())
            .then(events => {
                eventsList.innerHTML = "";
                events.forEach(event => {
                    const li = document.createElement("li");
                    li.textContent = `${event.name} - ${event.date} - ${event.type}`;
                    eventsList.appendChild(li);
                });
            });
    });
});
