$(document).ready(function(){


    // MODAL EDITAR QUANTIDADE

    $('.btn-editar').on('click', function(){

        //Pega os dados do botão clicado
        const id = $(this).attr('data-id');
        const quantidade = $(this).attr('data-quantidade');
        const modelo = $(this).attr('data-model')

        //Preeche os dados do modal
        $('#editarId').val(id);
        $('#editarQuantidade').val(quantidade);
        $('#editarModelo').val(modelo);

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