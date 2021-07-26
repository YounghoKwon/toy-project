
$(function() {
    searchNotice();
});

function deleteNotice(id) {
    $.ajax({
        url: "/api/notice/"+id,
        type:"DELETE",
    }).done(function (response) {
        alert("삭제에 성공하셧습니다.");
        searchNotice();
    }).fail(function(xhr, status, errorThrown) {
        console.log("오류명: " + errorThrown );
        console.log("상태: " + status);
    });
}

function searchNotice() {
    var search_text = $('#search_text').val();
    $.ajax({
        url: "/api/notice/?search_text="+search_text,
        type:"GET",
    }).done(function (response) {
        $('#notice_body').text("");
        var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' }
        for (var notice_detail in response.content) {
            var detail = response.content[notice_detail];
            var update_date = new Date(detail.updateDate).toLocaleDateString(undefined, options);
            update_date =  update_date === null ? "" : update_date;
            var user_name = detail.user === null ? "" : detail.user.name ;
            $('#notice_body').append('<tr></tr>')
            $('#notice_body').append('<td>'+detail.title+"</td>")
            $('#notice_body').append('<td>'+user_name+'</td>')
            $('#notice_body').append('<td>'+update_date +'</td>');
            $('#notice_body').append('<td>'+ '<input value="상세 보기" class="btn btn-info" type="button" onclick="viewNotice('+detail.id+')" />'+'</td>')
            $('#notice_body').append('<td>'+ '<input value="수정" class="btn btn-success" type="button" onclick="modifyNotice('+detail.id+')" />'+'</td>')
            $('#notice_body').append('<td>'+ '<input value="삭제" class="btn btn-danger" type="button" onclick="deleteNotice('+detail.id+')" />'+'</td>')
            $('#notice_body').append('</tr>')
        }
    }).fail(function(xhr, status, errorThrown) {
        console.log("오류명: " + errorThrown );
        console.log("상태: " + status);
    });
}


function createNotice() {
    location.href = "/notice/create/";
}

function modifyNotice(id) {
    location.href = "/notice/modify/"+id;
}

function viewNotice(id) {
    location.href = "/notice/detail/"+id;
}
