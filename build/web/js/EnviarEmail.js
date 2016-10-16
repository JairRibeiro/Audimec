

function EnviarEmail(){
    
    var nome = $('#nome').val();
    var email = $('#email').val();
    var mensagem = $('#mensagem').val();
    
    $.ajax({
        type:'POST',
        url:'EnviarEmail',
        dataType: "json",
        data: {
            nome:nome,
            email:email,
            mensagem:mensagem
        },
        sucess: function(retorno){
            //O QUE DEVE SER RETORNADO
        },
        errs: function(){
            //Mensagem de erro no sistema
        }
        
    });
    
}