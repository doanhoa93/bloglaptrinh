function showMessage(type, msg, selector){
    var alertBox = '';
    if(type == 'error'){
        alertBox = '<div class="alert alert-danger">'+'<span class="closebtn" onclick="this.parentElement.style.display=\'none\';">&times;</span>'+'<strong>Thất bại!</strong>'+msg+'</div>';
        $(selector).html(alertBox);
    } else if(type == 'success'){
        alertBox = '<div class="alert alert-info">'+'<span class="closebtn" onclick="this.parentElement.style.display=\'none\';">&times;</span>'+'<strong>Thành công.</strong>'+msg+'</div>';
        $(selector).html(alertBox);
    }
}