
document.addEventListener("DOMContentLoaded", function() {
    var switchInput = document.getElementById('flexSwitchCheckDefault');
    var label = document.getElementById('disponibleLabel');

    switchInput.addEventListener('change', function() {
    if (this.checked) {
        label.innerText = 'Disponible';
    } else {
        label.innerText = 'No Disponible';
    }
    });
});
