
$(function() {
    getNotice($('#notice_id').val());
});

function getNotice(id) {
    $.ajax({
        url: "/api/notice/"+id,
        type:"GET",
    }).done(function (response) {
        var options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' }
        var update_date = new Date(response.updateDate).toLocaleDateString(undefined, options);
        $('#contents_textarea').text(response.contents);
        $('#update_date').text(update_date);
        $('#title').text(response.title);
        $('#user_name').text(response.user.name);
    }).fail(function(xhr, status, errorThrown) {
        console.log("오류명: " + errorThrown );
        console.log("상태: " + status);
    });
}

