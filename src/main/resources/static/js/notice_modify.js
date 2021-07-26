
$(function() {
    getNotice($('#notice_id').val());

});

function getNotice(id) {
    $.ajax({
        url: "/api/notice/"+id,
        type:"GET",
    }).done(function (response) {
        $('#contents_textarea').text(response.contents);
        // $('#update_date').val(response.updateDate);
        $('#title').val(response.title);
        // $('#user_name').text(response.user.name);
    }).fail(function(xhr, status, errorThrown) {
        console.log("오류명: " + errorThrown );
        console.log("상태: " + status);
    });
}

function noticeModify() {
    var id = $('#notice_id').val();
    var title = $('#title').val();
    var contents = $('#contents_textarea').val();
    var data = new Object();
    data.id = id;
    data.title = title;
    data.contents = contents;
    $.ajax({
        url: "/api/notice/",
        contentType: 'application/json',
        type:"PATCH",
        data: JSON.stringify(data),
    }).done(function (response) {
        alert("수정에 성공하셧습니다.");
    }).fail(function(xhr, status, errorThrown) {

        if(xhr.status === 400){
            var field = xhr.responseJSON.errors[0].field;
            var message = xhr.responseJSON.errors[0].defaultMessage;
            alert((field === 'title' ? '제목' : "") + message );
        }


    });
}



