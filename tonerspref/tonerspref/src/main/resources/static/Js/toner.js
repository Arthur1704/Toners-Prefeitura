$(document).ready(function(){


    // MODAL EDITAR QUANTIDADE

    $('.btn-editar').on('click', function(){

        //Pega os dados do botão clicado
        const id = $(this).data('id');
        const quantidade = $(this).data('quantidade');

        //Preeche os dados do modal
        $('#editarId').val(id);
        $('#editarQuantidade').val(quantidade);

        //Abre o modal
        $('#modalEditar').modal('show');
    });

    // MODAL DELETAR

    $('.btn-deletar').on('click', function(){

        //Pega os dados do botão clicado
        const id = $(this).data('id');
        const modelo = $(this).data('modelo');

        // Preenche o modal
        $('#deletarId').val(id);
        $('#deletarModelo').text(modelo);

        //Abre o modal
        $('#modalDeletar').modal('show');
    });

});