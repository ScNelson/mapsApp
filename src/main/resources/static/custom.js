var map;
var marker;
//var coords = { lat: 39.9612, lng: -82.9988 };
var contentString = '<h2>' + city + ', ' + state + '</h2>';

function initMap() {
    var infowindow = new google.maps.InfoWindow({
        content: contentString
    });
    var image = {
        url: '/diamonds.png',
        scaledSize: new google.maps.Size(50, 50)
    };
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 10,
        scrollwheel: false
    });
    marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.DROP
    });
    google.maps.event.addListener(marker, 'click', function () {
        infowindow.open(map, marker);
    });
}