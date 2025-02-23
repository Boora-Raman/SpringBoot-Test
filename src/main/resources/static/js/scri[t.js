// Function to send POST request when "Sign Up" button is clicked
function signup() {
    const user = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    fetch('/api/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(data => alert(`User ${data.username} signed up successfully!`))
    .catch(error => console.error('Error:', error));
}

// Function to send GET request when "Get All Users" button is clicked
function getUsers() {
    fetch('/api/users/all')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            alert(`Fetched ${data.length} users! Check console for details.`);
        })
        .catch(error => console.error('Error:', error));
}
