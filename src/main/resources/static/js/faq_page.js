let coll = document.getElementsByClassName('main_content_information');
const arrow = document.getElementsByClassName('arrow');
for (let i = 0;i<coll.length;i++){
    coll[i].addEventListener('click',function (){
        console.log(coll[i])
        arrow[i].classList.toggle('rotate');
        let content = this.nextElementSibling;
        if (content.style.maxHeight){
            content.style.maxHeight = null;
            content.style.paddingTop = null;
            content.style.paddingBottom = null;
        }
        else {
            content.style.maxHeight = content.scrollHeight+30 + 'px';
            content.style.paddingTop = 16 + 'px';
            content.style.paddingBottom = 16 + 'px';
            content.style.borderRadius= '0px 0px 10px 10px';
        }
    })
}