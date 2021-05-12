var items = document.getElementsByClassName('item');
var points = document.getElementsByClassName('point');
var goPreBtn = document.getElementById('goPre');
var goNextBtn = document.getElementById('goNext');
var index = 0;
var clearActive = function () {
    for (var i = 0; i < items.length; i++) {
        items[i].className = 'item';
    }
    for (var i = 0; i < points.length; i++) {
        points[i].className = 'point';
    }
}
var goIndex = function () {
    clearActive();
    items[index].className = 'item active';
    points[index].className = 'point active';
}

var goNext = function() {
    index = (index + 1) % (items.length);
    goIndex();
}

var goPre = function () {
    index = (index - 1 + items.length) % items.length;
    // console.log(index);
    goIndex();
}

goNextBtn.addEventListener('click', function () {
    goNext();
})

goPreBtn.addEventListener('click', function () {
    goPre();
})

for (var i = 0; i < points.length; i++) {
    points[i].addEventListener('click', function () {
        var pointIndex = this.getAttribute('data-index');
        index = pointIndex;
        goIndex();

    })
}

