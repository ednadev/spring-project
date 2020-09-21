var main = {
    init: function() {
        var _this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        });

        $('#file').on('change', function(e) {
            _this.upload(e);
        });
    },
    save: function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href='/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    upload(event) {
        var formData = new FormData();
        formData.append('uploadFile', event.target.files[0]);

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