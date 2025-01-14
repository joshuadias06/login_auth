// Função para exibir mensagens
function displayMessage(message, color) {
    const messageDiv = document.getElementById('message');
    messageDiv.textContent = message;
    messageDiv.style.color = color;
}
// Formulário de login
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch(`http://localhost:8080/auth/login?username=${username}&password=${password}`, {
        method: 'POST',
    })
        .then(response => response.text())
        .then(message => {
            if (message.includes('Login bem sucedido')) {
                displayMessage(message, 'green');
            } else {
                displayMessage('Credenciais inválidas!', 'red');
            }
        })
        .catch(error => {
            displayMessage('Erro ao fazer login!', 'red');
        });
});
