const container = document.querySelector('.all_cart');
const btnLeft = document.getElementById('btnLeft');
const btnRight = document.getElementById('btnRight');
const containerSecond = document.querySelector('.happy_client_block_comment');
const btnLeftSecond = document.getElementById('btnLeftSecond');
const btnRightSecond = document.getElementById('btnRightSecond');
const moveLeft = () => {
    const currentLeft = parseInt(window.getComputedStyle(container).left) || 0;
    const newLeft = currentLeft - 120;
    const containerWidth = container.getBoundingClientRect().width;

    if (newLeft > -containerWidth) {
        container.style.left = newLeft + 'px';
    }
};

const moveRight = () => {
    const currentLeft = parseInt(window.getComputedStyle(container).left) || 0;
    const newLeft = currentLeft + 120;

    if (newLeft <= 0) {
        container.style.left = newLeft + 'px';
    }
};

btnLeft.addEventListener('click', moveLeft);
btnRight.addEventListener('click', moveRight);

const moveLeftSecond = () => {
    const currentLeft = parseInt(window.getComputedStyle(containerSecond).left) || 0;
    const newLeft = currentLeft - 120;
    const containerWidth = containerSecond.getBoundingClientRect().width;

    if (newLeft > -containerWidth) {
        containerSecond.style.left = newLeft + 'px';
    }
};

const moveRightSecond = () => {
    const currentLeft = parseInt(window.getComputedStyle(containerSecond).left) || 0;
    const newLeft = currentLeft + 120;

    if (newLeft <= 0) {
        containerSecond.style.left = newLeft + 'px';
    }
};



btnLeftSecond.addEventListener('click', moveLeftSecond);
btnRightSecond.addEventListener('click', moveRightSecond);