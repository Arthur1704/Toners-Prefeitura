$(document).ready(function(){

    $('.btn-diminuir').on('click', function(){
        
        const tonerId = $(this).data('id');

        $.ajax({
            url: '/toners/diminuir',
            type: 'POST',
            data: {
                id: tonerId
            },
            success: function (novaQuantidade) {
                $('#qtd-' + tonerId).text(novaQuantidade);
            },
            error: function () {
                alert('Erro ao diminuir a quantidade');
            }
        });
    });
});