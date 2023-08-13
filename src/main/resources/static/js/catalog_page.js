var selectElement = document.getElementById("country");

var outputContainer = document.getElementsByClassName("city");

var arrayCity;


selectElement.addEventListener("change", function() {
    // Получаем выбранное значение
    var selectedValue = selectElement.value;



    var xhr = new XMLHttpRequest();

    xhr.open('POST', '/js/city', false);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            arrayCity = JSON.parse(xhr.responseText);
        } else {
            console.error('Ошибка запроса: ' + xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('Ошибка запроса');
    };

    xhr.send(JSON.stringify(selectedValue));

    for (var  i = 0; i<outputContainer.length;i++){
        if (i>=arrayCity.length){
            outputContainer[i].style.display = "none";
            continue;
        }
        var outputElements = outputContainer[i].getElementsByTagName("p");
        var input = outputContainer[i].getElementsByTagName("input");
        outputContainer[i].style.display = "";
        outputElements[0].textContent = arrayCity[i];
        input[0].value = arrayCity[i];
    }

});


var makeReset = document.getElementById('make_reset');

makeReset.addEventListener('click', function(){

var ell = document.getElementById('make');

ell.value = 'all';

})


var vehicleTypeReset = document.getElementById('vehicle_type_reset');

vehicleTypeReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('vehicle_type_block');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})


var kilometerReset = document.getElementById('kilometer_reset');

kilometerReset.addEventListener('click', function(){

    var min = document.getElementById('kilometers_min');
    var max = document.getElementById('kilometers_max');

    min.value = '';
    max.value = '';

})

var priceReset = document.getElementById('price_reset');

priceReset.addEventListener('click', function(){

    var min = document.getElementById('price_min');
    var max = document.getElementById('price_max');

    min.value = '';
    max.value = '';

})

var countryReset = document.getElementById('country_reset');

countryReset.addEventListener('click', function(){

    var ell = document.getElementById('country');

    ell.value = 'All';

    var selectedValue = 'All';



    var xhr = new XMLHttpRequest();

    xhr.open('POST', '/js/city', false);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onload = function() {
        if (xhr.status >= 200 && xhr.status < 300) {
            arrayCity = JSON.parse(xhr.responseText);
        } else {
            console.error('Ошибка запроса: ' + xhr.statusText);
        }
    };

    xhr.onerror = function() {
        console.error('Ошибка запроса');
    };

    xhr.send(JSON.stringify(selectedValue));

    for (var  i = 0; i<outputContainer.length;i++){
        if (i>=arrayCity.length){
            outputContainer[i].style.display = "none";
            continue;
        }
        var outputElements = outputContainer[i].getElementsByTagName("p");
        var input = outputContainer[i].getElementsByTagName("input");
        outputContainer[i].style.display = "";
        outputElements[0].textContent = arrayCity[i];
        input[0].value = arrayCity[i];
    }

})



var cylindersReset = document.getElementById('cylinders_reset');

cylindersReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('cylinders');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})


var colorReset = document.getElementById('color_reset');

colorReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('color');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})


var seatsReset = document.getElementById('seats_reset');

seatsReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('seats');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})

var fuelTypeReset = document.getElementById('fuel_type_reset');

fuelTypeReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('fuel_type');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})


var transmissionReset = document.getElementById('transmission_reset');

transmissionReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('transmission');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})



var cityReset = document.getElementById('city_reset');

cityReset.addEventListener('click', function(){

    var ell = document.getElementsByClassName('city');

    for (var i = 0; i<ell.length;i++){
        var input = ell[i].getElementsByTagName("input");
        input[0].checked = false;
    }

})