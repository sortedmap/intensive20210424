$(function(){

    let showInterface = function(login) {
        $('.main').css('display', 'flex');
        //TODO: display user name
    };

    let registerUser = function(login){
        $.post('/api/auth', {"login": login}, function(response){
            if(response.result) {
                showInterface(login);
            } else {
                alert(response.error);
            }
        });
    };

    $.get('/api/auth', {}, function(response){
        if(response.result) {
            showInterface(response.login)
        }
        else {
            let login = prompt('Введите Ваше имя:');
            registerUser(login);
        }
    });
});