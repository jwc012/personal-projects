$(document).ready(function() {
    window.onload = function () {
        $('.preloader').fadeOut(3500, function(){ 
            $('.preloader').remove(); 
        });
    }
    $(window).scroll( function(){
        $('h2').each( function(i){
            var bottomOfH2Element = $(this).offset().top + $(this).outerHeight();
            var bottomOfPElement = $(this).next().offset().top + $(this).next().outerHeight();
            var bottomOfWindow = $(window).scrollTop() + $(window).height();
            
            if(bottomOfWindow > bottomOfH2Element){
                $(this).animate({'opacity':'1','margin-left':'0px'}, 1000);
            }
            if(bottomOfWindow > bottomOfPElement){
                $(this).next().animate({'opacity':'1','margin-left':'0px'}, 1000);
            }
            
        }); 
    });
   //  setTimeout(function(){
   //      $(".WelcomeVideo")[0].play();
   //  }, 3000);
   // $(".WelcomeVideo").prop("volume", .20); 
});