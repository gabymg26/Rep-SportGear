document.getElementById('implementoSelect').addEventListener('change', function() {let select = document.getElementById('implementoSelect');
    let estadoInput = document.getElementById('estado');
    let selectedOption = select.options[select.selectedIndex];
    let estado = selectedOption.dataset.estado;
    estadoInput.value = estado;
});