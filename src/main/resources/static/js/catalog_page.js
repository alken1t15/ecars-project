var selectElement = document.getElementById("country");

var outputContainer = document.getElementsByClassName("vehicle_type_city");

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