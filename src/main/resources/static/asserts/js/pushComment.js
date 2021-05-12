var SearchBtn = document.getElementById("pushComment");

SearchBtn.addEventListener("click", function(data) {//点击搜索
    var content = document.getElementById("content").value;//字段名和值
    // alert(content);
    $.ajax({
        url: "/comments",
        type: "post",
        async:false,
        data: {
            "content":content,
        },
        success: function (data) {
            window.location.reload();
        },
        error: function (data) {
            alert(data + "操作暂时失效");
        }
    })
});