var SearchBtn = document.getElementById("searchBtn");

SearchBtn.addEventListener("click", function(data) {//点击搜索
    var name = document.getElementById("search-input").value;//字段名和值
    // alert(name);
    $.ajax({
        url: "/movicePlay/searchMovice",
        type: "post",
        // contentType: "application/json",
        // dataType:"json",
        async:false,
        data: {
            "name":name,
            "page": 1
        },
        success: function (data) {
            window.location.href="/search";
        },
        error: function (data) {
            alert("操作暂时失效");
        }
    })
});