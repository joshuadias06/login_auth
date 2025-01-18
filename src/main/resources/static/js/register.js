function displayMessage(message, color) {
    const messageDiv = document.getElementById('message');
    messageDiv.textContent = message;
    messageDiv.style.color = color;
}

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('regUsername').value;
    const password = document.getElementById('regPassword').value;

    // Fazendo a requisição de registro
    fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + localStorage.getItem('jwtToken'), // Enviando o token JWT se ele estiver armazenado
        },
        body: JSON.stringify({ username, password }),
        credentials: 'include' // Para enviar credenciais (se necessário)
    })
        .then(response => response.text())
        .then(message => {
            displayMessage(message, 'green');
        })
        .catch(error => {
            displayMessage('Erro ao registrar usuário!', 'red');
        });
});
