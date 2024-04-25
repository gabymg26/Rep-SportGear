document.addEventListener("DOMContentLoaded", function() {
    let select = document.getElementById('implementoSelect');
    let categoriaInput = document.getElementById('categoria');

    select.addEventListener('change', function() {
        let selectedOption = select.options[select.selectedIndex];
        let categoria = selectedOption.dataset.category;
        categoriaInput.value = categoria;
    });

    if (select.options.length > 0) {
        let selectedOption = select.options[0];
        let categoria = selectedOption.dataset.category;
        categoriaInput.value = categoria;
    }
});