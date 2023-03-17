// top-net 스크롤 제한..    ----------------------------------------------------------------
window.addEventListener("wheel", function(e){
    e.preventDefault();
},{passive : false});

var mhtml = $("html");
var page = 1;

mhtml.animate({scrollTop:0},10);

function topNetScroll(){
    
    $(window).on("wheel", function(e){
    
        if(document.querySelector('html').scrollTop == 0){
            
            if(mhtml.is(":animated")) return;

            if(e.originalEvent.deltaY > 0) {
                if(page == 400) return;
                page++;
            } else if(e.originalEvent.deltaY < 0) {
                if(page == 1) return;
                page--;
            }
            var posTop =(page-1) * $(".top-net").height();
            console.log(posTop);
            mhtml.animate({scrollTop : posTop});
        }
        else{
            window.removeEventListener("wheel", function(e){
                e.preventDefault();
            },{passive : false});
        }
    });    
};

if(document.querySelector('html').scrollTop == 0)
{
    topNetScroll();
}
//------------------------------------------------------------------------------------------





