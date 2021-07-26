
$(function() {
});

function createNotice() {
    var title = $('#title').val();
    var contents = $('#contents_textarea').val();
    var data = new Object();
    data.title = title;
    data.contents = contents;
    $.ajax({
        url: "/api/notice/",
        contentType: 'application/json',
        type:"POST",
        data: JSON.stringify(data),
    }).done(function (response) {
        alert("등록에 성공하셧습니다.");
        location.href = "/notice/list/";
    }).fail(function(xhr, status, errorThrown) {
        if(xhr.status === 400){
            var field = xhr.responseJSON.errors[0].field;
            var message = xhr.responseJSON.errors[0].defaultMessage;
            alert((field === 'title' ? '제목' : "") + message );
        }
    });
}

function createNotice2() {
    var title = $('#title').val();
    var contents = $('#contents_textarea').val();
    var data = new Object();
    data.title = title;
    data.contents = contents;

    const formData = new FormData();
    // formData.append("file", data.file);
    formData.append(
        "key",
        new Blob([JSON.stringify(data.info)], { type: "application/json" })
    );

    $.ajax({
        url: "/api/notice/upload",
        contentType: 'multipart/form-data',
        type:"POST",
        data: formData,
    }).done(function (response) {
        alert("등록에 성공하셧습니다.");
        location.href = "/notice/list/";
    }).fail(function(xhr, status, errorThrown) {
        if(xhr.status === 400){
            var field = xhr.responseJSON.errors[0].field;
            var message = xhr.responseJSON.errors[0].defaultMessage;
            alert((field === 'title' ? '제목' : "") + message );
        }
    });
}
