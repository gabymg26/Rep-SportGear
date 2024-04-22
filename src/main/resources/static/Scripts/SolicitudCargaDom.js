document.addEventListener("DOMContentLoaded", function() {
    let select = document.getElementById('implementoSelect');
    let categoriaInput = document.getElementById('categoria');
    let estadoInput = document.getElementById('estado');

    if (select.options.length > 0) {
        let selectedOption = select.options[0];
        let categoria = selectedOption.dataset.category;
        let estado = selectedOption.dataset.estado;
        categoriaInput.value = categoria;
        estadoInput.value = estado;
    }
});