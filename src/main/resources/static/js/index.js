var main = {
    init: function() {
        var _this = this;

        $('#file').on('change', function(e) {
            _this.upload(e);
        });
    },
    upload(event) {
        var formData = new FormData();
        formData.append('uploadFile', event.target.files[0]);
        formData.append('userName', $('#userName').val());

        $.ajax({
            type: 'POST',
            url: '/api/gallery',
            data: formData,
            contentType: false,
            processData: false
        }).done(function() {
            alert('이미지가 등록되었습니다.');
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();

function openChild(id) {
    window.open("/gallery/"+id, "popup", "width=570, height=350");
}