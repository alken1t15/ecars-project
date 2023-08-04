$.ajax({
    url: "http://localhost:8080/catalog/tg",
    type: "GET",
    dataType: "json",
    success: function(data) {
        // Обработка полученных данных
        console.log(data);
    }
});