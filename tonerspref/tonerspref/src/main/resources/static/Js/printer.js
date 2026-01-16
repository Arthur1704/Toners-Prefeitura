$(document).ready(function(){   
    
    $('.btn-editar').on('click', function(){

        const id = $(this).data('id');
        const modelo = $(this).data('modelo')

        $('#editarId').val(id);
        $('#editar').val(modelo)

        $('#modalEditar').modal('show');
    });


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