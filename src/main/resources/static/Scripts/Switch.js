document.addEventListener("DOMContentLoaded", function() {
    var switchInput = document.getElementById('flexSwitchCheckDefault');
    var label = document.getElementById('disponibleLabel');

    function updateLabel() {
        if (switchInput.checked) {
            label.innerText = 'Disponible';
        } else {
            label.innerText = 'No Disponible';
        }
    }

    // Actualizar el texto del label al cargar la página
    updateLabel();

    // Agregar un event listener al switch para actualizar el texto del label cuando cambie
    switchInput.addEventListener('change', function() {
        updateLabel();
    });
});
