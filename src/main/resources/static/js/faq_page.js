function toggleContent(header) {
    var arrow = header.querySelector('.arrow');
    var content = header.nextElementSibling;

    content.classList.toggle('show');
    arrow.classList.toggle('rotate');
}
