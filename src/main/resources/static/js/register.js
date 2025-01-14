// Função para exibir mensagens
function displayMessage(message, color) {
    const messageDiv = document.getElementById('message');
    messageDiv.textContent = message;
    messageDiv.style.color = color;
}

// Formulário de registro
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('regUsername').value;
    const password = document.getElementById('regPassword').value;

    fetch('http://localhost:8080/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
    })
        .then(response => response.text())
        .then(message => {
            displayMessage(message, 'green');
        })
        .catch(error => {
            displayMessage('Erro ao registrar usuário!', 'red');
        });
});