const container = document.querySelector('.details_block_first_left_similar_second_block');
const btnLeft = document.getElementById('btnLeft');
const btnRight = document.getElementById('btnRight');
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