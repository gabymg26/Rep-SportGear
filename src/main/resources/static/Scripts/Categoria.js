document.getElementById('implementoSelect').addEventListener('change', function() {let select = document.getElementById('implementoSelect');
    let categoriaInput = document.getElementById('categoria');
    let selectedOption = select.options[select.selectedIndex];
    let categoria = selectedOption.dataset.category;
    categoriaInput.value = categoria;
});